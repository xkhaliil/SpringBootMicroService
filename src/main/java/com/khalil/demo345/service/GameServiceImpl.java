package com.khalil.demo345.service;

import com.khalil.demo345.entities.Game;
import com.khalil.demo345.repos.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameServiceImpl implements GameService{

    @Autowired
    GameRepository gameRepository;

    @Override
    public Game saveGame(Game p) {
        return gameRepository.save(p);
    }

    @Override
    public Game updateGame(Game p) {
        return gameRepository.save(p);
    }

    @Override
    public void deleteGame(Game p) {
        gameRepository.delete(p);
    }

    @Override
    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }

    @Override
    public Game getGame(Long id) {
        return gameRepository.findById(id).get();
    }

    @Override
    public List<Game> getAllGames() {
        return gameRepository.findAll();
    }

    @Override
    public Page<Game> getAllGamesParPage(int page, int size) {
        return gameRepository.findAll(PageRequest.of(page, size));
    }
}
