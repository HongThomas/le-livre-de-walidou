package com.project.LivreDeWalidou.model.repository;

import com.project.LivreDeWalidou.model.IGame;

import java.util.List;

public interface IGameRepository {
    List<IGame> getGamesByTitle(String title);
    List<IGame> getGames();
    void addGame(IGame game);
    void saveGame(IGame game);
}
