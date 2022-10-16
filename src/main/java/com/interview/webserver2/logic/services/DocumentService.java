package com.interview.webserver2.logic.services;

import com.interview.webserver2.model.Create;
import com.interview.webserver2.model.CreateCallback;

import java.util.concurrent.CompletableFuture;

public interface DocumentService {
    CompletableFuture<CreateCallback> sendToSecondServer(Create create) throws InterruptedException;
}
