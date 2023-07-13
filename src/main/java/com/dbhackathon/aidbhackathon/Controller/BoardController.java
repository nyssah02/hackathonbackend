package com.dbhackathon.aidbhackathon.Controller;

import com.dbhackathon.aidbhackathon.Service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BoardController {

  @Autowired
  private BoardService boardService;

  // Get cards from board
  @GetMapping("api/v1/{key}/{token}/board/cards")
  public ResponseEntity<Object> getCards(@PathVariable String key, @PathVariable String token){
    return new ResponseEntity<>(boardService.getCards(key, token), HttpStatus.ACCEPTED);
  }
}
