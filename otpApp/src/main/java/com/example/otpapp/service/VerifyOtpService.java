package com.example.otpapp.service;

import com.example.otpapp.rest.OtpResponse;
import com.example.otpapp.rest.VerifyOtpRequest;

public interface VerifyOtpService {
    OtpResponse verifyOtp(VerifyOtpRequest verifyOtpRequest);
}
