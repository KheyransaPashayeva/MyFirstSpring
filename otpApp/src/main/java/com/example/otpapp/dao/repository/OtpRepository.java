package com.example.otpapp.dao.repository;

import com.example.otpapp.dao.entity.OtpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity,Long> {
    Optional<OtpEntity> findByMsisdn(String msisdn);
}
