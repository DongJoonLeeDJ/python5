package com.example.member.repository;


import com.example.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// select insert update delete
public interface MemberRepository extends JpaRepository<Member,Long> {

}
