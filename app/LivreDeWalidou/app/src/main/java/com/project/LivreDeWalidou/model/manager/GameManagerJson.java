package com.project.LivreDeWalidou.model.manager;

import android.util.Log;

import com.project.LivreDeWalidou.model.Game;
import com.project.LivreDeWalidou.model.IGame;
import com.project.LivreDeWalidou.model.comp.IStoryItem;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GameManagerJson implements GameManager {

    private final Gson gson = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(StoryImage.class, new StoryImageAdapter())
            .registerTypeAdapter(IStoryItem.class, new IStoryItemAdapter())
            .serializeNulls()
            .create();

    @Override
    public IGame createGame(InputStreamReader isr) throws IOException {
        IGame game = gson.fromJson(isr, Game.class);
        Log.d("IMPORT JSON", gson.toJson(game));
        isr.close();
        return game;
    }

    @Override
    public void saveGame(OutputStreamWriter osw, IGame game) throws IOException {
        String json = gson.toJson(game);
        osw.write(json);
        Log.d("SAVE GAME", json);
        osw.flush();
        osw.close();
    }
}
