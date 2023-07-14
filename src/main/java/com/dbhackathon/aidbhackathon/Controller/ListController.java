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

    private final String key = "91612427ee0f74310de5ef91528701e7";
    private final String token = "ATTA110c31d5e96713397c540ff0510b2698b23c5ee16d166cd3c091e47315a048f2B4AFA9F5";

    // Get a list
    @GetMapping("api/v1/lists/{idList}")
    public ResponseEntity<List> getList(@PathVariable String idList) throws IOException {
        return new ResponseEntity<>(listService.getList(key, idList, token), HttpStatus.ACCEPTED);
    }
//    public HttpStatus getList(@PathVariable String key, @PathVariable String token, @PathVariable String idList) {
//        listService.getList(key, idList, token);
//        return HttpStatus.OK;
//    }

    // Create a list
    @PostMapping("api/v1/lists/post")
    public HttpStatus createList(@RequestBody List list) {
        listService.createList(list,key,token);
        return HttpStatus.OK;
    }

    // Update a list
    @PutMapping("api/v1/lists/{idList}")
    public HttpStatus updateList (@RequestBody List list, @PathVariable String idList) {
        listService.updateList(list, key, token, idList);
        return HttpStatus.OK;
    }

    // Delete a list
    @DeleteMapping("api/v1/list/{idCard}")
    public HttpStatus deleteList(@PathVariable String idCard) {
        return null;
    }
}
