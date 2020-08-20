package com.example.dddproject.repository;

import com.example.dddproject.entitiy.BoardEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class BoardRepository {

    private EntityManager em;

    private void save(BoardEntity boardEntity){
        em.persist(boardEntity);
    }
}
