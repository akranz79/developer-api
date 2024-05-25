package com.santander.service.impl;

import com.santander.domain.model.Developer;
import com.santander.domain.repository.DeveloperRepository;
import com.santander.service.DeveloperService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public Developer findById(Long id) {
        return developerRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Developer create(Developer developerToCreate) {
        if (developerToCreate.getId() != null && developerRepository.existsById(developerToCreate.getId())) {
            throw new IllegalArgumentException("This Developer ID already exists.");
        }
        return developerRepository.save(developerToCreate);
    }
}
