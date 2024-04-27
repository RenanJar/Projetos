package com.school.clientapi;

import com.school.dto.request.viacep.ViaCepResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "",url = "https://viacep.com.br/ws/")
public interface ViaCepClient {

    @RequestMapping(method = RequestMethod.GET, value="{cep}/json", produces = "application/json")
    ViaCepResponse getCEP(Long cep);
}
