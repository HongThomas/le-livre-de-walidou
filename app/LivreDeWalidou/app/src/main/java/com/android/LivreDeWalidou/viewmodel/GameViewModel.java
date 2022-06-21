package com.android.LivreDeWalidou.viewmodel;

import android.app.Application;
import android.content.ContextWrapper;

import androidx.lifecycle.AndroidViewModel;

import com.android.LivreDeWalidou.model.Game;
import com.android.LivreDeWalidou.model.repository.GameRepository;
import com.android.LivreDeWalidou.model.repository.IGameRepository;

import java.io.File;

public class GameViewModel extends AndroidViewModel {
    private IGameRepository repo;
    private Game currentGame;
    private static final String gamesFolderName = "games";

    public GameViewModel(Application app) {
        super(app);
        File appFolder = new ContextWrapper(app).getFilesDir();
        this.repo = new GameRepository(new File(appFolder, GameViewModel.gamesFolderName));
    }

}
