package com.example.CommunityServer.service;

import com.example.CommunityServer.dto.response.CommonResponse;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class ResponseService {
    public <T> CommonResponse<Object> getSuccessResponse(T data){
        return CommonResponse.builder()
                .success(true)
                .code(HttpStatus.OK.value())
                .message("요청에 성공하였습니다.")
                .data(data)
                .build();
    }
}
