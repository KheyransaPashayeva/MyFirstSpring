package com.example.otpapp.rest;

import com.example.otpapp.dao.repository.OtpRepository;
import com.example.otpapp.service.SendOtpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/otp")
public class OtpController {
    private final SendOtpService otpService;
    @PostMapping
    public OtpResponse sendSmsClient(@RequestBody SendOtpRequest request) {
        return otpService.sendOtp(request);
    }

}
