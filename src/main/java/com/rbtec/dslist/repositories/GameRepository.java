package com.rbtec.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rbtec.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
