package com.kb.apin.repository;

import com.kb.apin.entitiy.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board,Long> {

}
