package com.android.LivreDeWalidou.model.manager;

import com.android.LivreDeWalidou.model.IStory;
import com.android.LivreDeWalidou.model.Story;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import java.io.InputStreamReader;

public class StoryManagerJson implements StoryManager {
    private Gson gson = new GsonBuilder().setPrettyPrinting()
            .serializeNulls()
            .create();

    @Override
    public IStory createStory(InputStreamReader isr) throws JsonIOException {
        return gson.fromJson(isr, Story.class);
    }
}
