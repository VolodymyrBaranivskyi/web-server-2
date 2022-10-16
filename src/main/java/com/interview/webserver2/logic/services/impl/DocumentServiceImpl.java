package com.interview.webserver2.logic.services.impl;

import com.interview.webserver2.infra.microservices.SecondServerMicroserviceCaller;
import com.interview.webserver2.logic.services.DocumentService;
import com.interview.webserver2.model.Create;
import com.interview.webserver2.model.CreateCallback;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class DocumentServiceImpl implements DocumentService {
    private final SecondServerMicroserviceCaller caller;

    public DocumentServiceImpl(SecondServerMicroserviceCaller caller) {
        this.caller = caller;
    }

    @Override
    @Async("asyncExecutor")
    public CompletableFuture<CreateCallback> sendToSecondServer(Create create) throws InterruptedException {
        Thread.sleep(60000);
        log.info("start callback");
        CreateCallback createCallback = caller.getCallbackInfoCreate(create);
        log.info("callbackData, {}", createCallback);
        return CompletableFuture.completedFuture(createCallback);
    }
}
