package com.example.otpapp.service;

import com.example.otpapp.rest.OtpResponse;
import com.example.otpapp.rest.SendOtpRequest;
import org.springframework.stereotype.Component;


public interface SendOtpService {
    OtpResponse sendOtp(SendOtpRequest request);
}
