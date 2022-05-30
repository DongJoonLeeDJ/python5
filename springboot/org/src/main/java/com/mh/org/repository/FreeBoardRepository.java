package com.mh.org.repository;

import com.mh.org.entity.FreeBoard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FreeBoardRepository extends JpaRepository<FreeBoard,Long> {

    @Query(value = "select * from free_board " +
            "where wdate between :startdate and :enddate",
            nativeQuery=true)
    public List<FreeBoard> stateendselect(String startdate, String enddate);
//
//
//    List<TableName> findSomeCase(@Param("case_1") String case_1);

    public Page<FreeBoard> findByTitleContainingIgnoreCase(String title, Pageable pa);

    @Query(value = "select * from free_board where title like %:title% \n#pa\n",
            nativeQuery = true)
    public Page<FreeBoard> mycustomQuery(String title, Pageable pa);
}
