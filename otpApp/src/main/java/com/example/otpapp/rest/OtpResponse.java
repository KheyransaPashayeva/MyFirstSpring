package com.example.otpapp.rest;

import com.example.otpapp.util.enums.OtpStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

public record OtpResponse(OtpStatus otpStatus, @JsonInclude(JsonInclude.Include.NON_NULL) LocalDateTime expiredTime,
                          @JsonInclude(JsonInclude.Include.NON_NULL) LocalDateTime blockedTime) {
}
