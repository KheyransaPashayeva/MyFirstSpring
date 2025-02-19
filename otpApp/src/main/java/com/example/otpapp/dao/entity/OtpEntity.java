package com.example.otpapp.dao.entity;

import com.example.otpapp.util.enums.OtpStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "otp")
public class OtpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String otpCode;
    private String msisdn;
    private OtpStatus status;
    private Integer smsCount;
    private Integer verifyCount;
    @CreationTimestamp
    private LocalDateTime createdTime;
   @UpdateTimestamp
    private LocalDateTime updatedTime;
    private LocalDateTime blockedTime;

    private LocalDateTime expiredTime;

}
