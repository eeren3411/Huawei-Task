package com.demo.demo.controller;

import java.io.*;
import java.net.*;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Currency {
    private static final String url = "https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies";

    public static double getRate(String from, String to) throws IOException {
        String finalUrl = String.format("%s/%s/%s.json", url, from.toLowerCase(), to.toLowerCase());
        URL connectionURL = new URL(finalUrl);
        HttpURLConnection connection = (HttpURLConnection) connectionURL.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        Map<String, Object> responseMap = new ObjectMapper().readValue(response.toString(), HashMap.class);

        return Double.parseDouble(responseMap.get(to.toLowerCase()).toString());
    }
}
