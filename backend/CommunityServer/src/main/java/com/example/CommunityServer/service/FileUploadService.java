package com.example.CommunityServer.service;

import com.example.CommunityServer.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FileUploadService {
    private final CommunityRepository communityRepository;


}
