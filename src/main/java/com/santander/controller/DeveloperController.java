package com.santander.controller;

import com.santander.domain.model.Developer;
import com.santander.service.DeveloperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/developers")
public class DeveloperController {

    @Autowired
    private DeveloperService developerService;

    @GetMapping
    public List<Developer> getAllDevelopers() {
        return developerService.getAllDevelopers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Developer> getDeveloperById(@PathVariable Long id) {
        Developer developer = developerService.getDeveloperById(id);
        if (developer != null) {
            return ResponseEntity.ok(developer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Developer createDeveloper(@RequestBody Developer developer) {
        return developerService.createDeveloper(developer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDeveloper(@PathVariable Long id) {
        developerService.deleteDeveloper(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{developerId}/projects/{projectId}")
    public ResponseEntity<Developer> associateProjectToDeveloper(@PathVariable Long developerId, @PathVariable Long projectId) {
        Developer developer = developerService.associateProjectToDeveloper(developerId, projectId);
        return ResponseEntity.ok(developer);
    }
}
