package com.example.member.repository;


import com.example.member.entity.Board;
import com.example.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

// select insert update delete
public interface BoardRepository extends JpaRepository<Board,Long> {

}
