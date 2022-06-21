package com.android.LivreDeWalidou.model.manager;

import com.android.LivreDeWalidou.model.IStory;
import com.android.LivreDeWalidou.model.Story;
import com.android.LivreDeWalidou.model.comp.StoryImage;
import com.android.LivreDeWalidou.model.comp.StoryText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;

public class StoryManagerJson implements StoryManager {
    private Gson gson = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(StoryImage.class, StoryImageAdapter.class)
            .serializeNulls()
            .create();

    @Override
    public IStory createStory(InputStreamReader isr) throws JsonIOException {
        return gson.fromJson(isr, Story.class);
    }

    @Override
    public void saveStory(OutputStreamWriter osw, IStory story) throws IOException {
        osw.write(gson.toJson(story));
    }
}
