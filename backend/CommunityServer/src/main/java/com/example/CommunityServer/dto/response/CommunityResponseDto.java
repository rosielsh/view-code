package com.example.CommunityServer.dto.response;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommunityResponseDto {
    private Long communityId;
    private String name;
    private String iconImage;
}
