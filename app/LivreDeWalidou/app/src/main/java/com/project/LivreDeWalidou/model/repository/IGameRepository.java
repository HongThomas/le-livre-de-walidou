package com.project.LivreDeWalidou.model.repository;

import com.project.LivreDeWalidou.IPropertyChangeProvider;
import com.project.LivreDeWalidou.model.IGame;

import java.util.List;

public interface IGameRepository extends IPropertyChangeProvider {
    List<IGame> getGamesByTitle(String title);
    List<IGame> getGames();
    void addGame(IGame game);
    void saveGame(IGame game);
}
