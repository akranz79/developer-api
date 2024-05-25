package com.santander.service;

import com.santander.domain.model.Projeto;
import com.santander.domain.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public List<Projeto> getAllProjetos() {
        return projetoRepository.findAll();
    }

    public Projeto getProjetoById(Long id) {
        return projetoRepository.findById(id).orElse(null);
    }

    public Projeto createProjeto(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public void deleteProjeto(Long id) {
        projetoRepository.deleteById(id);
    }
}
