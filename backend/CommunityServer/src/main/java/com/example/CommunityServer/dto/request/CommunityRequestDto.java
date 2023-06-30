package com.example.CommunityServer.dto.request;

import com.example.CommunityServer.entity.Community;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommunityRequestDto {
    private String name;
    private String iconImage;

    public Community toCommunity(){
        return Community.builder()
                .name(this.name)
                .iconImage(this.iconImage)
                .build();
    }
}
