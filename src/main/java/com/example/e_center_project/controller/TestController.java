package com.example.e_center_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/getName")
    public ResponseEntity<String> getName() {
        return ResponseEntity.ok("Real Madrid");
    }

    @GetMapping("/people")
    public ResponseEntity<List<String>> getPeople() {
        return ResponseEntity.ok(List.of("Azizbek","Odil"));
    }
}
