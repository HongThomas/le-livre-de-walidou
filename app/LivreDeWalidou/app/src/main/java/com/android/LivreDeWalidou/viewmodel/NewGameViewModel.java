package com.android.LivreDeWalidou.viewmodel;

import com.android.LivreDeWalidou.model.repository.GameRepository;
import com.android.LivreDeWalidou.model.repository.StoryRepository;

public class NewGameViewModel {
    private StoryRepository stories;
    private GameRepository games;

    public void createNewGame() {
        this.games.addGame(null);
    }
}
