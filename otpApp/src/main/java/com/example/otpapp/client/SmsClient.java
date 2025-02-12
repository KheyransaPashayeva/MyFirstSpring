package com.example.otpapp.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SmsClient {
    public void sendSms(String msisdn, String code) {
        log.info("Otp code: {}, msisdn : {}", code, msisdn);
    }
}
