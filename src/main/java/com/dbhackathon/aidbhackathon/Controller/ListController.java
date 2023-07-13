package com.dbhackathon.aidbhackathon.Controller;

import com.dbhackathon.aidbhackathon.Entity.List;
import com.dbhackathon.aidbhackathon.Service.ListService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class ListController {

    @Autowired
    private ListService listService;

    private ListController listController;

    // Get a list
    @GetMapping("api/v1/{key}/{token}/lists/{idList}")
    public ResponseEntity<List> getList(@PathVariable String key, @PathVariable String idList, @PathVariable String token) throws IOException {
        return new ResponseEntity<>(listService.getList(key, idList, token), HttpStatus.ACCEPTED);
    }
//    public HttpStatus getList(@PathVariable String key, @PathVariable String token, @PathVariable String idList) {
//        listService.getList(key, idList, token);
//        return HttpStatus.OK;
//    }

    // Create a list
    @PostMapping("api/v1/{key}/{token}/lists/post")
    public HttpStatus createList(@RequestBody List list, @PathVariable String key, @PathVariable String token) {
        listService.createList(list,key,token);
        return HttpStatus.OK;
    }

    // Update a list
    @PutMapping("api/v1/{key}/{token}/lists/{idList}")
    public HttpStatus updateList (@RequestBody List list, @PathVariable String key, @PathVariable String token, @PathVariable String idList) {
        listService.updateList(list, key, token, idList);
        return HttpStatus.OK;
    }
}
