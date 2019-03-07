package com.solution.service;

import com.flexionmobile.codingchallenge.integration.Integration;
import com.flexionmobile.codingchallenge.integration.Purchase;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.solution.web.param.PurchaseResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class WebIntegration implements Integration {
    private final static String BASE_URL = "http://sandbox.flexionmobile.com/javachallenge/rest/developer/";
    private final static String BUY_URL = "batman/buy/";
    private final static String GET_ALL_URL = "batman/all";
    private final static String CONSUME_URL = "batman/consume/";
    
    private Gson gson;
    private JsonParser jsonParser;

    public WebIntegration() {
        this.gson = new Gson();
        this.jsonParser = new JsonParser();
    }

    @Override
    public Purchase buy(String s) {
        String response = "";
        try {
            response += createConnection("POST", BUY_URL + s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson.fromJson(response, PurchaseResponse.class);
    }

    @Override
    public List<Purchase> getPurchases() {
        String response = "";
        try {
            response += createConnection("GET", GET_ALL_URL);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>(convertJsonToList(response));
    }

    @Override
    public void consume(Purchase purchase) {
        try {
           createConnection("POST", CONSUME_URL + purchase.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Purchase> convertJsonToList(String response) {
        JsonObject jsonObject = (JsonObject)jsonParser.parse(response);
        JsonArray jsonArr = jsonObject.getAsJsonArray("purchases");
        return gson.fromJson(jsonArr,  new TypeToken<List<PurchaseResponse>>() {}.getType());
    }

    private String createConnection(String methodType, String urlName) throws IOException {
        URL url = new URL(BASE_URL+urlName);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(methodType);
        connection.setRequestProperty("Content-Type", "application/json");
        return readResponse(connection);
    }

    private String readResponse (HttpURLConnection connection) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = reader.readLine()) != null) {
            content.append(inputLine);
        }
        reader.close();
        connection.disconnect();
        return content.toString();
    }
}
