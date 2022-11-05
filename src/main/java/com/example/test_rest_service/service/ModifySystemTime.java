package com.example.test_rest_service.service;

import com.example.test_rest_service.model.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ModifySystemTime")
@RequiredArgsConstructor
public class ModifySystemTime implements MyModifyService{
    @Override
    public Response modify(Response response) {
        response.setSystemTime("");
        return response;
    }
}
