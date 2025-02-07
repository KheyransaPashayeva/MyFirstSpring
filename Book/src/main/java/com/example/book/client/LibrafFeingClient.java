package com.example.book.client;

import com.example.book.dto.LibrafClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@FeignClient(name = "libraf", url = "http://localhost:8081/api/v1/libraf")
public interface LibrafFeingClient {

    @RequestMapping(method = RequestMethod.GET,value = "/all")
    List<LibrafClientDto> getLibrafAll();

    @RequestMapping(method = RequestMethod.POST)
    void addLibraf(@RequestBody LibrafClientDto librafClientDto);

}
