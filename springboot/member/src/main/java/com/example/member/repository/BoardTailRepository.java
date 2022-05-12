package com.example.member.repository;


import com.example.member.entity.Board;
import com.example.member.entity.BoardTail;
import org.springframework.data.jpa.repository.JpaRepository;

// select insert update delete
public interface BoardTailRepository extends JpaRepository<BoardTail,Long> {

}
