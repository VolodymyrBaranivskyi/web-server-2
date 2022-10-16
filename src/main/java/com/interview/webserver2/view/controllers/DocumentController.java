package com.interview.webserver2.view.controllers;

import com.interview.webserver2.logic.services.DocumentService;
import com.interview.webserver2.model.Create;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;


import static com.interview.webserver2.view.controllers.Response.ok;

@Slf4j
@RestController
@RequestMapping()
@Api(
        value = "Documents",
        description = "Operations related to documents")
public class DocumentController {

    private final com.interview.webserver2.logic.services.DocumentService documentService;

    @Autowired
    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @ApiIgnore
    @ApiOperation(
            value = "Get document from callback")
    @ApiResponse(
            code = 200,
            message = "Successfully retrieved list of all clients")
    @PostMapping("/document/create")
    public ResponseEntity<?> getDocument(@RequestBody com.interview.webserver2.model.Create create) throws InterruptedException {
        Create saveCreate = create;
        documentService.sendToSecondServer(saveCreate);
        return ok();
    }
}
