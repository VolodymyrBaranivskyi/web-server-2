package com.interview.webserver2.infra.microservices;

import com.interview.webserver2.model.Create;
import com.interview.webserver2.model.CreateCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class SecondServerMicroserviceCaller {


    private final RestTemplate restTemplate;

    @Autowired
    public SecondServerMicroserviceCaller(Environment environment) {
        this.restTemplate = new RestTemplate();
    }

    public CreateCallback getCallbackInfoCreate(Create request) {
        CreateCallback createCallback = new CreateCallback();
        createCallback.setState("1");
        createCallback.setNumber(1235);
        restTemplate.postForObject(request.getCallback_url(), createCallback, CreateCallback.class);
        return createCallback;
    }
}
