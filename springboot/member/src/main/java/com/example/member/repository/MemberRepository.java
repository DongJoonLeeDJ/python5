package com.example.member.repository;


import com.example.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// select insert update delete
public interface MemberRepository extends JpaRepository<Member,Long> {

    // select * from member where email = '?' ;
    public Member findByEmail(String email);

}
