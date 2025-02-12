package com.example.otpapp.service.impl;

import com.example.otpapp.client.SmsClient;
import com.example.otpapp.dao.entity.OtpEntity;
import com.example.otpapp.dao.repository.OtpRepository;
import com.example.otpapp.rest.OtpResponse;
import com.example.otpapp.rest.SendOtpRequest;
import com.example.otpapp.service.SendOtpService;
import com.example.otpapp.util.enums.OtpStatus;
import com.example.otpapp.util.helper.OtpGenerate;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class SendOtpServiceImpl implements SendOtpService {
    private final OtpRepository repository;
    private final OtpGenerate otpGenerate;
    private final SmsClient client;
    @Override
    public OtpResponse sendOtp(SendOtpRequest request) {
        Optional<OtpEntity> otpData=repository.findByMsisdn(request.msisdn());
        if(otpData.isPresent()){
            OtpEntity entity=otpData.get();
            if (entity.getStatus().equals(OtpStatus.BLOCK)) {
                if (entity.getBlockedTime().isAfter(LocalDateTime.now())){
                   return sendOtpResponse(entity);
                }
                else {
                    removeFromBlock(request.msisdn());
                    OtpEntity otpEntity=sendFirstTime(request.msisdn());
                    return sendOtpResponse(otpEntity);
                }
            }else{
                if(entity.getSmsCount()>=5){
                    entity.setStatus(OtpStatus.BLOCK);
                    entity.setExpiredTime(null);
                    entity.setBlockedTime(LocalDateTime.now().plusMinutes(5));
                  OtpEntity otpEntity=  repository.save(entity);
                    return sendOtpResponse(otpEntity) ;
                }
                else{
                    return ordinarySendOtp(entity);
                }
            }
        }else {

            //first time otp service
            OtpEntity entity = sendFirstTime(request.msisdn());
            client.sendSms(request.msisdn(),entity.getOtpCode());
            return sendOtpResponse(entity);

        }
    }
    private OtpResponse sendOtpResponse(OtpEntity entity) {
        return new OtpResponse(entity.getStatus(),entity.getExpiredTime(),entity.getBlockedTime());

    }
    private void removeFromBlock(String msisdn) {
        OtpEntity entity=repository.findByMsisdn(msisdn).get();
        repository.delete(entity);
    }

private OtpEntity sendFirstTime(String msisdn) {
        String code=otpGenerate.generateOtpResponse();
        OtpEntity entity=OtpEntity.builder()
                .otpCode(code)
                .msisdn(msisdn)
                .smsCount(1)
                .status(OtpStatus.Pending)
                .expiredTime(LocalDateTime.now().plusMinutes(5))
                .build();
        return repository.save(entity);
}
private OtpResponse ordinarySendOtp(OtpEntity otpData){
        otpData.setSmsCount(otpData.getSmsCount()+1);
        otpData.setStatus(OtpStatus.Pending);
//        otpData.setExpiredTime(LocalDateTime.now().plusMinutes(5));
        otpData.setOtpCode(otpGenerate.generateOtpResponse());
        OtpEntity entity=repository.save(otpData);
        client.sendSms(otpData.getMsisdn(),entity.getOtpCode());
        return sendOtpResponse(entity);
}

}
