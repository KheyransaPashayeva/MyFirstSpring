package com.example.otpapp.rest;

public record VerifyOtpRequest(String msisdn, String otpCode) {
}
