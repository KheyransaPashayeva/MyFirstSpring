package com.example.book.client;

import com.example.book.dto.AliVeNinoDto;
import com.example.book.dto.LibrafClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
@FeignClient(name = "alino", url = "http://localhost:8083/api/v1/alino")
public interface AliVeNinoFeingClient {

    @RequestMapping(method = RequestMethod.GET,value = "/all")
    List<AliVeNinoDto> getAliNoAll();

    @RequestMapping(method = RequestMethod.POST)
    void addLibraf(@RequestBody AliVeNinoDto dto);
}
