package com.santander.controller;

import com.santander.domain.model.Developer;
import com.santander.service.DeveloperService;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/developers")
public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> findById(@PathVariable Long id) {
        var developer = developerService.findById(id);
        return ResponseEntity.ok(developer);
    }

    @PostMapping
    public ResponseEntity<Developer> create(@RequestBody Developer developerToCreate){
        var developerCreated = developerService.create(developerToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(developerCreated.getId()).toUri();
        return ResponseEntity.created(location).body(developerCreated);
    }
}
