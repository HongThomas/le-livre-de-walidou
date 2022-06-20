package com.android.LivreDeWalidou.model.repository;

import com.android.LivreDeWalidou.model.Game;
import com.android.LivreDeWalidou.model.Story;
import com.android.LivreDeWalidou.model.loader.GameLoader;

import java.util.List;

public class GameRepository {
    private List<Game> games;
    private GameLoader loader;

    public Game getGame(){
        return null;
    }

    public void addGame(Story newGame) {

    }

    public List<Game> getGames() {
        return this.games;
    }
}
