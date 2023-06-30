package com.example.CommunityServer.service;


import com.example.CommunityServer.dto.request.CommunityRequestDto;
import com.example.CommunityServer.dto.response.CommunityResponseDto;
import com.example.CommunityServer.entity.Community;
import com.example.CommunityServer.entity.CommunityMember;
import com.example.CommunityServer.entity.Member;
import com.example.CommunityServer.entity.Role;
import com.example.CommunityServer.repository.CommunityMemberRepository;
import com.example.CommunityServer.repository.CommunityRepository;
import com.example.CommunityServer.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.util.ArrayList;
import java.util.List;

import static com.example.CommunityServer.entity.Role.ADMIN;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final MemberRepository memberRepository;
    private final CommunityMemberRepository communityMemberRepository;

    public long createCommunity(Long userId, MultipartFile file, String communityName){
        String filePath = "";
        // TODO 이미지 S3 서버 연결

        CommunityRequestDto communityRequestDto = CommunityRequestDto.builder()
                .name(communityName)
                .iconImage(filePath)
                .build();

        Community community = communityRequestDto.toCommunity();
        Community newCommunity = communityRepository.save(community);

        addCommunityMember(userId, newCommunity.getId(), ADMIN);

        return newCommunity.getId();
    }

    public Long addCommunityMember(Long userId, Long communityId, Role role){
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다."));
        Community community = communityRepository.findById(communityId)
                .orElseThrow(() -> new RuntimeException("멤버가 존재하지 않습니다."));
        CommunityMember communityMember = CommunityMember.builder()
                .community(community)
                .role(role)
                .nickname(member.getNickname())
                .profileImage(member.getProfileImage())
                .build();

        CommunityMember newCommunityMember = communityMemberRepository.save(communityMember);

        return newCommunityMember.getId();
    }

    public List<CommunityResponseDto> showCommunity(Long userId){
        List<CommunityMember> members = communityMemberRepository.findByUserId(userId);
        List<CommunityResponseDto> communityResponseDtos = new ArrayList<>();

        for (CommunityMember member : members){
            Community community = member.getCommunity();
            communityResponseDtos.add(community.toCommunityResponseDto());
        }

        return communityResponseDtos;
    }
}
