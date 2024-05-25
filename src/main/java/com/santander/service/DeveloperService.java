package com.santander.service;

import com.santander.domain.model.Developer;
import com.santander.domain.model.Projeto;
import com.santander.domain.repository.DeveloperRepository;
import com.santander.domain.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeveloperService {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Developer> getAllDevelopers() {
        return developerRepository.findAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepository.findById(id).orElse(null);
    }

    public Developer createDeveloper(Developer developer) {
        return developerRepository.save(developer);
    }

    public void deleteDeveloper(Long id) {
        developerRepository.deleteById(id);
    }

    public Developer associateProjectToDeveloper(Long developerId, Long projectId) {
        Developer developer = developerRepository.findById(developerId).orElseThrow(() -> new RuntimeException("Developer not found"));
        Projeto projeto = projetoRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));

        developer.getProjetos().add(projeto);
        return developerRepository.save(developer);
    }
}
