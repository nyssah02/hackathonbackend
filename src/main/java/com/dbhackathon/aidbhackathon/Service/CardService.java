package com.dbhackathon.aidbhackathon.Service;

import java.util.List;

import com.dbhackathon.aidbhackathon.Entity.Card;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

@Service
public class CardService {

  private final String idBoard = "64ae3754f1c66a66221e2f0d";

  // Get a specific card
  public Card getCard(String key, String token, String idCard) throws JsonProcessingException {
//    HttpResponse<JsonNode> response = Unirest.get("https://api.trello.com/1/cards/" + idCard)
//            .header("Accept", "application/json")
//            .queryString("key", key)
//            .queryString("token", token)
//            .asJson();
//
//    System.out.println(response.getBody());
//    return new Card();
    String result = Unirest.get("https://api.trello.com/1/cards/" + idCard)
            .header("Accept", "application/json")
            .queryString("key", key)
            .queryString("token", token)
            .asJson()
            .getBody()
            .getObject()
            .toString();

    ObjectMapper mapper = new ObjectMapper();
    Card card = mapper.readValue(result, Card.class);

    System.out.println(result);
    return card;
  }

  // Post a single card in a board in a list
  public void createCard(Card card, String key, String token){
    HttpResponse<JsonNode> response = Unirest.post("https://api.trello.com/1/cards")
            .header("Accept", "application/json")
            .queryString("idList", card.getIdList())
            .queryString("name", card.getName())
            .queryString("desc", card.getDesc())
            .queryString("key", key)
            .queryString("token", token)
            .asJson();
    System.out.println(response.getBody());
  }

  // Update a specific card
  public void updateCard(Card card, String key, String token, String idCard){
    HttpResponse<JsonNode> response = Unirest.put("https://api.trello.com/1/cards/" + idCard)
            .header("Accept", "application/json")
            .queryString("name", card.getName())
            .queryString("desc", card.getDesc())
            .queryString("key", key)
            .queryString("token", token)
            .asJson();

    System.out.println(response.getBody());
  }

  // Delete a specific card
  public void deleteCard(String key, String token, String idCard){
    HttpResponse<String> response = Unirest.delete("https://api.trello.com/1/cards/" + idCard)
            .queryString("key", key)
            .queryString("token", token)
            .asString();

    System.out.println(response.getBody());

  }

  // Post multiple cards in a list
  public void createCardList(List<Card> cards, String key, String token) {

  }
}
