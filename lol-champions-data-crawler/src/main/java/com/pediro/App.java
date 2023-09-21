package com.pediro;

import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

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
            List<Entity> entities = new Stack<Entity>();
            for (String championName : championNames) {
                Data championData = championsData.get(championName);
                String championLore = championDataOperations.getLore(championName);
                int championPrice = championDataOperations.getPrice(championName);
                String coverImage = "http://ddragon.leagueoflegends.com/cdn/img/champion/splash/" + championName + "_0.jpg";
                String thumbnailImage = "http://ddragon.leagueoflegends.com/cdn/img/champion/loading/" + championName + "_0.jpg";
                entities.add(new Entity(championName, coverImage, championLore, thumbnailImage, championPrice, championData.getTags(), championData.getInfo().getDifficulty()));
            }

            Products products = new Products(entities);

            ObjectMapper mapper = new ObjectMapper();
            SimpleModule module = new SimpleModule();
            module.addSerializer(Products.class, new ProductsSerializer());
            mapper.registerModule(module);

            String serializedProducts = mapper.writeValueAsString(products);
            FileWriter outputFile = new FileWriter("lol-champions-data-crawler\\src\\main\\java\\com\\pediro\\data\\dynamodb-data.json");
            outputFile.write(serializedProducts);
            outputFile.close();

        } catch (Exception ex) {
            //TODO: Add catch for each exception type
            System.out.println("An error occurred.");
        }        
    }
}
