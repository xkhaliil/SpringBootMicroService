package com.khalil.demo345.repos;

import com.khalil.demo345.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
