package com.example.CommunityServer.controller;

import com.example.CommunityServer.dto.response.CommonResponse;
import com.example.CommunityServer.service.CommunityService;
import com.example.CommunityServer.service.ResponseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
@Slf4j
public class CommunityController {
    private final CommunityService communityService;
    private final ResponseService responseService;

    public static final String ID = "id";
    public static final String AUTHORIZATION = "AUTHORIZATION";

    @GetMapping("/test")
    public String test(){
        return "커뮤니티 테스트 성공";
    }

//    TODO 생성
    @PostMapping("/create")
    public CommonResponse<Object> createCommunity(HttpServletRequest request, @RequestPart MultipartFile file, @RequestParam String communityName){
        Long userId = Long.parseLong(request.getHeader("id"));
        return responseService.getSuccessResponse(communityService.createCommunity(userId, file, communityName));
    }
//    TODO 조회
//    TODO 업데이트
//    TODO 삭제
//    TODO 가입
//    TODO 초대
}
