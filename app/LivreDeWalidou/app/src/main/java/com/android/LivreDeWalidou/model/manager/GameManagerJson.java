package com.android.LivreDeWalidou.model.manager;

import com.android.LivreDeWalidou.model.Game;
import com.android.LivreDeWalidou.model.IGame;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class GameManagerJson implements GameManager {

    private final Gson gson = new GsonBuilder().setPrettyPrinting()
            .serializeNulls()
            .create();

    @Override
    public IGame createGame(InputStreamReader isr) throws JsonIOException {
        return gson.fromJson(isr, Game.class);
    }

    @Override
    public void saveGame(OutputStreamWriter osw, IGame game) throws IOException {
        osw.write(gson.toJson(game));
    }
}
