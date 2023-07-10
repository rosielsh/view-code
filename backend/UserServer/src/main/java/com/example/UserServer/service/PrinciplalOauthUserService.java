package com.example.UserServer.service;

import com.example.UserServer.config.oauth.PrincipalDetails;
import com.example.UserServer.entity.Member;
import com.example.UserServer.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PrinciplalOauthUserService extends DefaultOAuth2UserService {
    @Autowired
    MemberRepository memberRepository;

//    깃허브로 부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException{
        log.info("userRequest:"+userRequest);
        log.info("getClientRegistraion:"+userRequest.getClientRegistration());  //client로 어떤 OAuth로 로그인이 되는지 나옴 => 깃허브니까 github
        log.info("getAccessToken:"+userRequest.getAccessToken());   //토큰 확인

        OAuth2User oAuth2User = super.loadUser(userRequest);
        // 로그인 -> code 리턴 -> accessToken 요청
        // userRequest 정보 -> loadUser함수 호출 -> 깃허브로 부터 정보 받아옴
        log.info("getAttributes:"+oAuth2User.getAttributes()); //유저 정보를 받아옴

//        회원가입
        String provider = userRequest.getClientRegistration().getClientId(); //client 참고
        String username = oAuth2User.getAttribute("name");
        String nickname = oAuth2User.getAttribute("login");
        String email = oAuth2User.getAttribute("email");
        String profileImg = oAuth2User.getAttribute("avatar_url");
        String role = "ROLE_USER";

        Member memberEntity = memberRepository.findByNickname(nickname);
//      정보가 없으면 회원가입
        if (memberEntity == null) {
            memberEntity = Member.builder()
                    .username(username)
                    .nickname(nickname)
                    .email(email)
                    .profileImg(profileImg)
                    .role(role)
                    .build();
            memberRepository.save(memberEntity);
        }


        return new PrincipalDetails(memberEntity, oAuth2User.getAttributes());
    }
}
