package com.nexos.app.repositories;

import com.nexos.app.model.ModificationRegister;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ModificationsRepository extends JpaRepository<ModificationRegister, Integer>{
    
}
