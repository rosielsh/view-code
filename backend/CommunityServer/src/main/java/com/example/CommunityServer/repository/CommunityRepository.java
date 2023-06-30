package com.example.CommunityServer.repository;

import com.example.CommunityServer.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
