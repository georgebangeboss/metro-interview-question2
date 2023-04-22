package com.metropolitan.childrenservice.controllers;

import com.metropolitan.childrenservice.models.Child;
import com.metropolitan.childrenservice.service.ChildService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/v1")
public class ChildController {
    private final ChildService childService;

    @PostMapping(value = "/addchild")
    @ResponseStatus(HttpStatus.CREATED)
    public Child createChild(@RequestBody Child childRequest) {
        return childService.createChild(childRequest);
    }

    @PutMapping(value = "/editchild")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Child updateChild(@RequestBody Child childRequest) {
        return childService.updateChild(childRequest);
    }

    @GetMapping(value = "/allchildren")
    public ResponseEntity<Map<String, Object>> getAllChildren(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        Pageable pageable= PageRequest.of(page,size);
        Map<String, Object> response=childService.getAllChildren(pageable);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/search/")
    public ResponseEntity<List<Child>> searchByName(@RequestParam String name) {
        return ResponseEntity.ok(childService.searchByName(name));
    }

}
