package com.example.librafapp.dao.repository;

import com.example.librafapp.dao.entity.LibrafEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibrafRepository extends JpaRepository<LibrafEntity,Long> {
}
