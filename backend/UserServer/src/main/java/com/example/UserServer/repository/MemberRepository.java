package com.example.UserServer.repository;

import com.example.UserServer.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    // SELECT * FROM user WHERE nickname = ?1
//    깃허브의 login 값은 중복이 안되기 때문에!!
    Member findByNickname(String nickname);
}
