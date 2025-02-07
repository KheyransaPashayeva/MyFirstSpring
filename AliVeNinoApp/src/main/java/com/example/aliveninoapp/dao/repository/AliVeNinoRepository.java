package com.example.aliveninoapp.dao.repository;

import com.example.aliveninoapp.dao.entity.AliVeNinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliVeNinoRepository extends JpaRepository<AliVeNinoEntity,Long> {
}
