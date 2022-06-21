package com.android.LivreDeWalidou.viewmodel;

import com.android.LivreDeWalidou.model.Game;
import com.android.LivreDeWalidou.model.repository.GameRepository;
import com.android.LivreDeWalidou.view.LoadGameActivity;

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
