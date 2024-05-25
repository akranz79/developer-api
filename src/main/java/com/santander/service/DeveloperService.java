package com.santander.service;

import com.santander.domain.model.Developer;

public interface DeveloperService {

    Developer findById(Long id);

    Developer create(Developer developerToCreate);

}