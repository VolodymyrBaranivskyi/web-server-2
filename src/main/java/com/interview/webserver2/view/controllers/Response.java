package com.interview.webserver2.view.controllers;

import org.springframework.http.ResponseEntity;

import static org.springframework.http.HttpStatus.*;

public class Response {

    private Response() {
    }

    public static ResponseEntity<?> ok() {
        return new ResponseEntity<>(OK);
    }

}
