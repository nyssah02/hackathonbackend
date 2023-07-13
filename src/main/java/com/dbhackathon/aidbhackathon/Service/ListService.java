package com.dbhackathon.aidbhackathon.Service;

import com.dbhackathon.aidbhackathon.Entity.List;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;


@Service
public class ListService {
    // Get list
    public List getList(String key, String idList, String token) {
        HttpResponse<String> response = Unirest.get("https://api.trello.com/1/lists/{id}")
                .queryString("key", "APIKey")
                .queryString("token", "APIToken")
                .asString();

        System.out.println(response.getBody());
        return new List();
    }

    // Create List
    public void createList(List list, String key, String token) {
        HttpResponse<String> response = Unirest.post("https://api.trello.com/1/lists")
                .queryString("name", "{name}")
                .queryString("idBoard", "5abbe4b7ddc1b351ef961414")
                .queryString("key", "APIKey")
                .queryString("token", "APIToken")
                .asString();

        System.out.println(response.getBody());
    }

    // Update List
    public void updateList(List list, String key, String token) {

    }

}
