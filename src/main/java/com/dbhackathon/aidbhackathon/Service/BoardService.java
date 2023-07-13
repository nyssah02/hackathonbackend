package com.dbhackathon.aidbhackathon.Service;

import com.dbhackathon.aidbhackathon.Entity.Board;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoardService {

//  @Autowired
  private RestTemplate restTemplate;

  public List<Board> getCards(String key, String token){
    return Arrays.asList(restTemplate.getForObject(
        "https://api.trello.com/1/boards/eDnDc9FO/cards?key=" + key + "&token=" + token,
        Board[].class));
  }
}
