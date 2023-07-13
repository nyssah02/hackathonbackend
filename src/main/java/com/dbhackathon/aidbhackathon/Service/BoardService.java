package com.dbhackathon.aidbhackathon.Service;

import com.dbhackathon.aidbhackathon.Entity.Board;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BoardService {

  // Get Board
  public Board getBoard(String key, String token) {
    return new Board();
  }
}
