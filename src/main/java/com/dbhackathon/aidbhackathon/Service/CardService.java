package com.dbhackathon.aidbhackathon.Service;

import java.util.List;

import com.dbhackathon.aidbhackathon.Entity.Card;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import org.springframework.stereotype.Service;

@Service
public class CardService {

  // Get a specific card
  public Card getCard(String key, String token, String idCard){
    HttpResponse<JsonNode> response = Unirest.get("https://api.trello.com/1/cards/{id}")
            .header("Accept", "application/json")
            .queryString("key", "APIKey")
            .queryString("token", "APIToken")
            .asJson();

    System.out.println(response.getBody());
    // ?? :(
    return new Card();
  }

  // Post a single card in a board in a list
  public void createCard(Card card, String key, String token){
    HttpResponse<JsonNode> response = Unirest.post("https://api.trello.com/1/cards")
            .header("Accept", "application/json")
            .queryString("idList", "5abbe4b7ddc1b351ef961414")
            .queryString("key", key)
            .queryString("token", token)
            .asJson();
    System.out.println(response.getBody());
  }

  // Update a specific card
  public void updateCard(Card card, String key, String token, String idCard){

  }

  // Delete a specific card
  public void deleteCard(String key, String token, String idCard){

  }

  // Post multiple cards in a list
  public void postCardList(List<Card> cards, String key, String token) {

  }

//  // Post a card in a board in a list
//  public void postCard(Card card, String key, String token){
//    String url =
//            "https://api.trello.com/1/cards?key=" + key +
//                    "&token=" + token +
//                    "&name="+card.getName()+"&idBoard="+idBoard+"&idList="+card.getIdList();
//
//    HttpResponse<JsonNode> response = Unirest.post("https://api.trello.com/1/cards")
//            .header("Accept", "application/json")
//            .queryString("idList", "5abbe4b7ddc1b351ef961414")
//            .queryString("key", "APIKey")
//            .queryString("token", "APIToken")
//            .asJson();
//
//    System.out.println(response.getBody());
//  }
//
//  // Get card
//  public Card getCard(String key, String token, String idCard){
//    return restTemplate.getForObject(
//            "https://api.trello.com/1/cards/"+ idCard + "?key=" + key + "&token=" + token,
//            Card.class);
//  }
//
//  // Update card
//  public void updateCard(Card card, String key, String token, String idCard){
//    restTemplate.put(
//            "https://api.trello.com/1/cards/" + idCard + "?key=" + key + "&token=" + token, card,
//            Card.class);
//  }
//
//  // Delete card
//  public void deleteCard(String key, String token, String idCard){
//    restTemplate.delete(
//            "https://api.trello.com/1/cards/" + idCard + "?key=" + key + "&token=" + token);
//  }


}
