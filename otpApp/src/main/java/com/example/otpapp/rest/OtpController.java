package com.example.otpapp.rest;

import com.example.otpapp.dao.repository.OtpRepository;
import com.example.otpapp.service.SendOtpService;
import com.example.otpapp.service.VerifyOtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/otp")
public class OtpController {
    private final SendOtpService otpService;
    private  final VerifyOtpService verifyOtpService;
    @PostMapping
    public OtpResponse sendSmsClient(@RequestBody SendOtpRequest request) {
        return otpService.sendOtp(request);
    }
    @PostMapping("verify")
    public OtpResponse verifyOtp(@RequestBody VerifyOtpRequest request) {
        return verifyOtpService.verifyOtp(request);
    }

}
