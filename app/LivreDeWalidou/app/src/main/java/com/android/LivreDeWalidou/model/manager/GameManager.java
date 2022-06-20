package com.android.LivreDeWalidou.model.manager;

import com.android.LivreDeWalidou.model.IGame;
import com.google.gson.JsonIOException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public interface GameManager {
    IGame createGame(InputStreamReader isr) throws JsonIOException;
    void saveGame(OutputStreamWriter osw, IGame game) throws IOException;
}
