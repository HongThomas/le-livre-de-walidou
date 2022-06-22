package com.project.LivreDeWalidou.model.manager;

import android.util.Log;

import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.Story;
import com.project.LivreDeWalidou.model.comp.IStoryItem;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StoryManagerJson implements StoryManager {
    public Gson gson = new GsonBuilder().setPrettyPrinting()
            .registerTypeAdapter(StoryImage.class, new StoryImageAdapter())
            .registerTypeAdapter(IStoryItem.class, new IStoryItemAdapter())
            .serializeNulls()
            .create();

    @Override
    public IStory createStory(InputStreamReader isr) throws IOException {
        IStory story = gson.fromJson(isr, Story.class);
        Log.d("IMPORT JSON", gson.toJson(story));
        isr.close();
        return story;
    }

    @Override
    public void saveStory(OutputStreamWriter osw, IStory story) throws IOException {
        String json = gson.toJson(story);
        Log.d("CREATION STORY", json);
        osw.write(json);
        osw.flush();
        osw.close();
    }
}
