package com.android.LivreDeWalidou.model.repository;

import android.os.Environment;

import com.android.LivreDeWalidou.model.Game;
import com.android.LivreDeWalidou.model.IGame;
import com.android.LivreDeWalidou.model.Story;
import com.android.LivreDeWalidou.model.manager.GameManager;
import com.android.LivreDeWalidou.model.manager.GameManagerJson;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GameRepository implements IGameRepository {
    private List<IGame> games;
    private GameManager gameManager;
    private File gameFolder;

    public GameRepository() {
        this.games = new ArrayList<>();
        this.gameManager = new GameManagerJson();
        File dataFolder = Environment.getDataDirectory();
        File gameFolder = new File(dataFolder, "games");
        try {
            gameFolder.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File[] files = gameFolder.listFiles(new JsonFileFilter());
        for(File json : files) {
            try {
                this.games.add(this.gameManager.createGame(new FileReader(json)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<IGame> getGamesByTitle(String title) {
        return this.games.stream().filter(game -> game.getStory().getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<IGame> getGames() {
        return this.games;
    }

    @Override
    public void addGame(IGame game) {
        this.games.add(game);
    }

    @Override
    public void saveGame(IGame game) {
        File json;
        int i = 0;
        do {
            json = new File(this.gameFolder, String.format("%s_%s_%d", game.getStory().getTitle().getContent(), game.hashCode(), i));
            i++;
        } while(json.exists());
        try {
            this.gameManager.saveGame(new FileWriter(json), game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
