package com.dbhackathon.aidbhackathon.Service;

import com.dbhackathon.aidbhackathon.Entity.List;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.GetRequest;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;


@Service
public class ListService {

    private final String idBoard = "64ae3754f1c66a66221e2f0d";

    // Get list
    public List getList(String key, String idList, String token) throws IOException {
        String result = Unirest.get("https://api.trello.com/1/lists/" + idList)
                .queryString("key", key)
                .queryString("token", token)
                .asJson()
                .getBody()
                .getObject()
                .toString();

        ObjectMapper mapper = new ObjectMapper();
        List list = mapper.readValue(result, List.class);

        System.out.println(result);
        return list;
    }

    // Create List
    public void createList(List list, String key, String token) {
        HttpResponse<String> response = Unirest.post("https://api.trello.com/1/lists")
                .queryString("name", list.getName())
                .queryString("idBoard", idBoard)
                .queryString("key", key)
                .queryString("token", token)
                .asString();

        System.out.println(response.getBody());
    }

    // Update List
    public void updateList(List list, String key, String token, String idList) {
        HttpResponse<String> response = Unirest.put("https://api.trello.com/1/lists/" + idList)
                .queryString("key", key)
                .queryString("token", token)
                .queryString("name", list.getName())
                .asString();

        System.out.println(response.getBody());
    }

    // Delete list

}
