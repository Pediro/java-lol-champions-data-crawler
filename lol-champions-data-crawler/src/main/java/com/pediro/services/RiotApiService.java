package com.pediro.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RiotApiService {
    
    public String GetJson(String urlString) throws IOException, Exception {
        URL championsJsonUrl = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) championsJsonUrl.openConnection();
        connection.setRequestMethod("GET");

        if (connection.getResponseCode() != 200) {
            throw new Exception("Failed to get data");
        }

        BufferedReader bufferReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        
        //I know the format of these file is just one line and therefore I know I can get away with this
        return bufferReader.readLine();
    }
}
