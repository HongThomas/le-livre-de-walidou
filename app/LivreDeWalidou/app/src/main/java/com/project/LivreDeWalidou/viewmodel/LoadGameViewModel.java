package com.project.LivreDeWalidou.viewmodel;

import com.project.LivreDeWalidou.model.Game;
import com.project.LivreDeWalidou.model.repository.GameRepository;
import com.project.LivreDeWalidou.view.LoadGameActivity;

public class LoadGameViewModel {
    private GameRepository games;
    private LoadGameActivity selectedGame;

    public LoadGameViewModel(GameRepository games, LoadGameActivity selectedGame) {
        this.games = games;
        this.selectedGame = selectedGame;
    }

    public void loadGame(Game game) {
        //this.selectedGame.setCurrentGame(this.games.load(game));
    }

}
