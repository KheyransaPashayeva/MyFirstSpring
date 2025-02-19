package com.example.otpapp.service.impl;

import com.example.otpapp.dao.entity.OtpEntity;
import com.example.otpapp.dao.repository.OtpRepository;
import com.example.otpapp.rest.OtpResponse;
import com.example.otpapp.rest.VerifyOtpRequest;
import com.example.otpapp.service.VerifyOtpService;
import com.example.otpapp.util.enums.OtpStatus;
import com.example.otpapp.util.helper.ServiceHelperOtp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VerifyOtpServiceImpl implements VerifyOtpService {
    private final OtpRepository otpRepository;
    private final ServiceHelperOtp serviceHelperOtp;
    @Override
    public OtpResponse verifyOtp(VerifyOtpRequest verifyOtpRequest) {
        Optional<OtpEntity> entity = otpRepository.findByMsisdn(verifyOtpRequest.msisdn());
        if (entity.isPresent()) {
            OtpEntity otpData = entity.get();
            if (otpData.getStatus().equals(OtpStatus.BLOCK) && otpData.getBlockedTime().isAfter(LocalDateTime.now())) {
                return new OtpResponse(OtpStatus.BLOCK, null, otpData.getBlockedTime());
            }
            if (otpData.getStatus().equals(OtpStatus.BLOCK) && otpData.getBlockedTime().isBefore(LocalDateTime.now())) {
                serviceHelperOtp.removeOtp(otpData.getMsisdn());
                return new OtpResponse(OtpStatus.Expired, null, null);
            }
            if (otpData.getExpiredTime().isBefore(LocalDateTime.now())) {
                return new OtpResponse(OtpStatus.Expired, null, null);

            }
            if (otpData.getOtpCode().equals(verifyOtpRequest.otpCode())) {
                serviceHelperOtp.removeOtp(otpData.getMsisdn());
                return new OtpResponse(OtpStatus.Success, null, null);
            } else {
                int verifyCount = Optional.ofNullable(otpData.getVerifyCount()).orElse(0) + 1;
                var blockTime = LocalDateTime.now().plusMinutes(5);
                if (verifyCount >= 5) {
                    otpData.setStatus(OtpStatus.BLOCK);
                    otpData.setBlockedTime(blockTime);
                    otpData.setVerifyCount(verifyCount);
                    otpData.setExpiredTime(null);
                    otpRepository.save(otpData);
                    return new OtpResponse(OtpStatus.BLOCK, null, blockTime);
                } else {
                    otpData.setStatus(OtpStatus.Failed);
                    otpData.setVerifyCount(verifyCount);
                    otpRepository.save(otpData);
                    return new OtpResponse(OtpStatus.Failed, null, null);
                }
            }
        } else {
            return new OtpResponse(OtpStatus.NOTFOUND, null, null);
        }
    }
}

