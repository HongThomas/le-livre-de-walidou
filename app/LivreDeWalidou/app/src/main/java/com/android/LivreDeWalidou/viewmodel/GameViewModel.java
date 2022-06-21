package com.android.LivreDeWalidou.viewmodel;

import com.android.LivreDeWalidou.model.Game;
import com.android.LivreDeWalidou.model.repository.GameRepository;
import com.android.LivreDeWalidou.view.GameActivity;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GameViewModel {
    private GameRepository gameRepository;
    private Game currentGame;

    public GameViewModel(Game game, GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.currentGame = game;
    }

    public void gameAct() {
        PropertyChangeListener listener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                
            }
        }
        this.currentGame.addPropertyChangeListener();
    }


}
