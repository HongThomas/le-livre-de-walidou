package com.project.LivreDeWalidou.model.repository;

import com.project.LivreDeWalidou.model.IGame;
import com.project.LivreDeWalidou.model.manager.GameManager;
import com.project.LivreDeWalidou.model.manager.GameManagerJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameRepository implements IGameRepository {
    private List<IGame> games;
    private GameManager gameManager;
    private File gamesFolder;

    public GameRepository(File gamesFolder) {
        this.games = new ArrayList<>();
        this.gameManager = new GameManagerJson();
        this.gamesFolder = gamesFolder;

        this.gamesFolder.mkdirs();

        File[] files = this.gamesFolder.listFiles(new JsonFileFilter());

        Arrays.stream(files).forEach(json -> {
            try {
                this.gameManager.createGame(new FileReader(json));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
        this.saveGame(game);
    }

    @Override
    public void saveGame(IGame game) {
        File json = json = new File(this.gamesFolder, String.format("%s_%s", game.getStory().getTitle().getContent(), game.hashCode())+".json");
        try {
            this.gameManager.saveGame(new FileWriter(json), game);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
