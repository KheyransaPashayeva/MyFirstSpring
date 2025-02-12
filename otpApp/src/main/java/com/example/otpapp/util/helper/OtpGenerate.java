package com.example.otpapp.util.helper;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class OtpGenerate {
    public String generateOtpResponse() {
        String otp= String.format("%06d",new Random().nextInt(100000));
        return otp;
    }
}
