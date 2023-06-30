package com.example.CommunityServer.entity;

import com.example.CommunityServer.dto.response.CommunityResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@Table(name = "community")
@NoArgsConstructor
@AllArgsConstructor
public class Community{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "community_id")
    private Long id;

    private String name;

    private String iconImage;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    public void createdAt(){
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    @PreUpdate
    public void updatedAt(){
        this.updatedAt = LocalDateTime.now();
    }

    public CommunityResponseDto toCommunityResponseDto(){
        return CommunityResponseDto.builder()
                .communityId(id)
                .name(name)
                .iconImage(iconImage)
                .build();
    }

    public void modifyName(String name){
        this.name = name;
    }
}
