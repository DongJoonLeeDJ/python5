package com.mh.org.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class FreeBoardRepositoryTest {

    @Autowired
    FreeBoardRepository freeBoardRepository;

    @Test
    void stateendselect() {
        freeBoardRepository.findById(1L);
    }

    @Test
    void findByTitleContainingIgnoreCase() {
    }

    @Test
    void mycustomQuery() {
    }
}