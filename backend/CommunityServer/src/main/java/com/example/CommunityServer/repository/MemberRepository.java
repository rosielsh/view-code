package com.example.CommunityServer.repository;

import com.example.CommunityServer.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
