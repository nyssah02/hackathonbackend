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

  private final String key = "91612427ee0f74310de5ef91528701e7";
  private final String token = "ATTA110c31d5e96713397c540ff0510b2698b23c5ee16d166cd3c091e47315a048f2B4AFA9F5";

  // Get cards from board
  @GetMapping("api/v1/board/cards")
  public ResponseEntity<Object> getCards(){
    return new ResponseEntity<>(boardService.getBoard(key, token), HttpStatus.ACCEPTED);
  }


}
