package com.project.LivreDeWalidou.viewmodel;

import com.project.LivreDeWalidou.model.repository.GameRepository;
import com.project.LivreDeWalidou.model.repository.StoryRepository;

public class NewGameViewModel {
    private StoryRepository stories;
    private GameRepository games;

    public void createNewGame() {
        this.games.addGame(null);
    }
}
