package com.pediro.operations;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pediro.models.champion.Data;
import com.pediro.models.champion.JsonResponse;
import com.pediro.services.RiotApiService;

public class ChampionDataOperations {
    
    public Map<String, Data> getChampionsData() throws Exception {
        RiotApiService riotApiService = new RiotApiService();
        String jsonString = riotApiService.GetJson("http://ddragon.leagueoflegends.com/cdn/13.18.1/data/en_US/champion.json");
        JsonResponse jsonResponse = new ObjectMapper().readValue(jsonString, JsonResponse.class);

        return jsonResponse.getData();
    }

    public String getLore(String championName) throws Exception {
        RiotApiService riotApiService = new RiotApiService();
        String jsonString = riotApiService.GetJson("http://ddragon.leagueoflegends.com/cdn/13.18.1/data/en_US/champion/" + championName + ".json");
        
        //Ignoring rest of json as I just want the lore from this API endpoint
        JsonNode jsonNode = new ObjectMapper().readTree(jsonString);
        return jsonNode.get("data").get(championName).get("lore").asText();       
    }

    public int getPrice(String championName) throws Exception {
        try {
            File championCostsFile = new File("lol-champions-data-crawler\\src\\main\\java\\com\\pediro\\data\\champion-costs.json");
            Scanner myReader  = new Scanner(championCostsFile);
            String jsonString = myReader.nextLine();
            myReader.close();
            JsonNode championCosts = new ObjectMapper().readTree(jsonString);

            return championCosts.get(championName).intValue();
        } catch (Exception ex) {
            System.out.print("Failed to get price for champion (" + championName +")");            
            throw ex;
        }
    }
}
