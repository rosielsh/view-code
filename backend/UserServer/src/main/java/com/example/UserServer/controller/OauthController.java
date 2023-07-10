package com.example.UserServer.controller;

import com.example.UserServer.config.oauth.PrincipalDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class OauthController {
    @PostMapping("/member")
    public ResponseEntity<Map<String, Object>> getMember(@AuthenticationPrincipal PrincipalDetails principalDetails) {
        Map<String, Object> memberInfo = new HashMap<>();

        Map<String, Object> attributes = principalDetails.getAttributes();
        memberInfo.put("nickname", attributes.get("login"));
        memberInfo.put("profileImg", attributes.get("avatar_url"));
        memberInfo.put("username", attributes.get("name"));
        memberInfo.put("email", attributes.get("email"));
        log.info("Oauth controller 호출");
        return ResponseEntity.ok(memberInfo);
    }
}
