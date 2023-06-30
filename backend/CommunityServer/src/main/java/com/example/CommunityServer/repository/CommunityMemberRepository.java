package com.example.CommunityServer.repository;

import com.example.CommunityServer.entity.CommunityMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityMemberRepository extends JpaRepository<CommunityMember, Long> {
    List<CommunityMember> findByUserId(Long userId);
}
