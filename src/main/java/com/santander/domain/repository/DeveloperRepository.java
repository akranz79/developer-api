package com.santander.domain.repository;

import com.santander.domain.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository extends JpaRepository <Developer, Long>{
}


