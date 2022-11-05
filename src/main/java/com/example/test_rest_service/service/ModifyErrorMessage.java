package com.example.test_rest_service.service;

import com.example.test_rest_service.model.Response;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("ModifyErrorMessage")
public class ModifyErrorMessage implements MyModifyService{
    @Override
    public Response modify(Response response) {
        response.setErrorMessage("Error");
        return response;
    }
}
