package com.project.LivreDeWalidou.viewmodel;

import android.app.Application;
import android.content.ContextWrapper;

import androidx.lifecycle.AndroidViewModel;

import com.project.LivreDeWalidou.model.Game;
import com.project.LivreDeWalidou.model.repository.GameRepository;
import com.project.LivreDeWalidou.model.repository.IGameRepository;

import java.io.File;

public class GameViewModel extends AndroidViewModel {
    private IGameRepository repo;
    private Game currentGame;

    public GameViewModel(Application app) {
        super(app);
        File appFolder = new ContextWrapper(app).getFilesDir();
        //this.repo = new GameRepository(new File(appFolder, GameViewModel.gamesFolderName));
    }

}
