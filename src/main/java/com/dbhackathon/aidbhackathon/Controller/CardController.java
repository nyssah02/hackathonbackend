package com.dbhackathon.aidbhackathon.Controller;

import java.util.List;

import com.dbhackathon.aidbhackathon.Entity.Card;
import com.dbhackathon.aidbhackathon.Service.CardService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

  @Autowired
  private CardService cardService;

  private BoardController boardController;

  // Get a card
  @GetMapping("api/v1/{key}/{token}/cards/{idCard}")
  public ResponseEntity<Card> getCard
  (@PathVariable String key, @PathVariable String token, @PathVariable String idCard) throws JsonProcessingException {
    return new ResponseEntity<>(cardService.getCard(key, token, idCard), HttpStatus.ACCEPTED);
  }
//  public HttpStatus getCard(@PathVariable String key, @PathVariable String token, @PathVariable String idCard) throws JsonProcessingException {
//    cardService.getCard(key, token, idCard);
//    return HttpStatus.OK;
//  }

  // Create a card
  @PostMapping("api/v1/{key}/{token}/cards/post")
  public HttpStatus createCard(@RequestBody Card card, @PathVariable String key, @PathVariable String token) {
    cardService.createCard(card, key, token);
    return HttpStatus.OK;
  }

  // Update a card
  @PutMapping("api/v1/{key}/{token}/cards/{idCard}")
  public HttpStatus updateCard
  (@RequestBody Card card, @PathVariable String key,
      @PathVariable String token, @PathVariable String idCard){
    cardService.updateCard(card, key, token, idCard);
    return HttpStatus.OK;
  }

  // Delete a card
  @DeleteMapping("api/v1/{key}/{token}/cards/{idCard}")
  public HttpStatus deleteCard
  (@PathVariable String key, @PathVariable String token, @PathVariable String idCard){
    cardService.deleteCard(key, token, idCard);
    return HttpStatus.OK;
  }

  // Create multiple cards in a list
  @PostMapping("api/v1/{key}/{token}/cards/createList")
  public HttpStatus createCardList(@RequestBody List<Card> cards, @PathVariable String key, @PathVariable String token) {
    cardService.postCardList(cards, key, token);
    return HttpStatus.OK;
  }
}
