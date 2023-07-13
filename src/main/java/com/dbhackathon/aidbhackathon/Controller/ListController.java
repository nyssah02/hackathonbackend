package com.dbhackathon.aidbhackathon.Controller;

import com.dbhackathon.aidbhackathon.Entity.List;
import com.dbhackathon.aidbhackathon.Service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ListController {

    @Autowired
    private ListService listService;

    private ListController listController;

    // Get a list
    @GetMapping("")
    public ResponseEntity<List> getList(@PathVariable String key, @PathVariable String idCard, @PathVariable String token) {
        return new ResponseEntity<>(listService.getList(key, token, idCard), HttpStatus.ACCEPTED);
    }

    // Create a list
    @PostMapping("")
    public HttpStatus createList(@RequestBody List list, @PathVariable String key, @PathVariable String idBoard, @PathVariable String token) {
        listService.createList(list,key,token);
        return HttpStatus.OK;
    }

    // Update a list

}
