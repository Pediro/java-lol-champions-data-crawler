package com.pediro;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.pediro.models.dynamodb.*;
import com.pediro.models.champion.Data;
import com.pediro.operations.ChampionDataOperations;
import com.pediro.serializers.ProductsSerializer;

public final class App {
    private App() {
    }

    public static void main(String[] args) throws Exception {
        try {
            ChampionDataOperations championDataOperations = new ChampionDataOperations();
            Map<String, Data> championsData = championDataOperations.getChampionsData();        
            Set<String> championNames = championsData.keySet();

            
            List<Entity> entities = new ArrayList<Entity>();
            for (String championName : championNames) {
                Data championData = championsData.get(championName);
                String championLore = championDataOperations.getLore(championName);
                int championPrice = championDataOperations.getPrice(championName);
                String coverImage = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + championName + "_0.jpg";
                String thumbnailImage = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championName + "_0.jpg";
                entities.add(new Entity(championName, coverImage, championLore, thumbnailImage, championPrice, championData.getTags(), championData.getInfo().getDifficulty()));
            }

            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(Products.class, new ProductsSerializer());
            mapper.registerModule(module);

            //Due to aws dynamodb limitation to 100 items per batch import we're creating two json files of champions
            int batchSize = 25;
            int batchIndex = 0;
            int interation = 1;
            while (batchIndex <= entities.size() - 1) {
                int toIndex = batchIndex + batchSize >= entities.size() - 1 ? entities.size() - 1 : batchIndex + batchSize;
                List<Entity> batch = entities.subList(batchIndex, toIndex);
                Products products = new Products(batch);
                
                String serializedProducts = mapper.writeValueAsString(products);
                String fileDir = String.format("src\\main\\java\\com\\pediro\\data\\champion-data-batch-%s.json", interation);
                FileWriter outputFile = new FileWriter(fileDir);
                outputFile.write(serializedProducts);
                outputFile.close();
                
                //Move batchIndex to the next subset of champions, unless it will pass the size of champions we are importing then set it to the size of the list
                batchIndex = batchIndex + batchSize;
                interation++;
            }

        } catch (Exception ex) {
            //TODO: Add catch for each exception type
            System.out.println(ex.getMessage());
            System.out.println(ex.getStackTrace());
        }        
    }
}
