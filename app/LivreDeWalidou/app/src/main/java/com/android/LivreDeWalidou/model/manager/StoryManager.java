package com.android.LivreDeWalidou.model.manager;

import com.android.LivreDeWalidou.model.IGame;
import com.android.LivreDeWalidou.model.IStory;
import com.google.gson.JsonIOException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public interface StoryManager {
    IStory createStory(InputStreamReader isr) throws JsonIOException;
    void saveStory(OutputStreamWriter osw, IStory story) throws IOException;
}
