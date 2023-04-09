package com.khalil.demo345.service;

import com.khalil.demo345.entities.Game;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GameService {
    Game saveGame(Game p);
    Game updateGame(Game p);
    void deleteGame(Game p);
    void deleteGameById(Long id);
    Game getGame(Long id);
    List<Game> getAllGames();
    Page<Game> getAllGamesParPage(int page, int size);

}
