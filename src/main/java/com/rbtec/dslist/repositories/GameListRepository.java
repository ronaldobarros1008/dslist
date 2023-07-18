package com.rbtec.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbtec.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
