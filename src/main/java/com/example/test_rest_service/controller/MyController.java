package com.example.test_rest_service.controller;

import com.example.test_rest_service.model.Request;
import com.example.test_rest_service.model.Response;
import com.example.test_rest_service.service.ModifyRequestService;
import com.example.test_rest_service.service.MyModifyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class MyController {

    private MyModifyService myModifyService;
    private ModifyRequestService modifyRequestService;

    @Autowired
    public MyController(@Qualifier("ModifySystemTime") MyModifyService myModifyService, ModifyRequestService modifyRequestService) {
        this.myModifyService = myModifyService;
        this.modifyRequestService = modifyRequestService;
    }

    @PostMapping(value = "/feedback")
    public ResponseEntity<Response> feedback(@RequestBody Request request) {
        log.info("incoming request:" + request);
        Response response = Response.builder()
                .uid(request.getUid())
                .operationUid(request.getOperationUid())
                .systemTime(request.getSystemTime())
                .code("success")
                .errorCode("234")
                .errorMessage("234")
                .build();

        modifyRequestService.modifyRq(request);
        Response modifiedResponse = myModifyService.modify(response);
        log.info("Outgoing request:" + modifiedResponse);
        return new ResponseEntity<Response>(modifiedResponse, HttpStatus.OK);
    }
}
