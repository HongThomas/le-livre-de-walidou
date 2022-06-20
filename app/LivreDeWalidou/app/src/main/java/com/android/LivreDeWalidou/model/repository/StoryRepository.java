package com.android.LivreDeWalidou.model.repository;

import android.os.Environment;

import com.android.LivreDeWalidou.model.IStory;
import com.android.LivreDeWalidou.model.Story;
import com.android.LivreDeWalidou.model.manager.StoryManager;
import com.android.LivreDeWalidou.model.manager.StoryManagerJson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoryRepository implements IStoryRepository {
    private List<IStory> stories;
    private StoryManager storyManager;
    private File storiesFolder;

    public StoryRepository() {
        this.stories = new ArrayList<>();
        this.storyManager = new StoryManagerJson();
        File dataFolder = Environment.getDataDirectory();
        this.storiesFolder = new File(dataFolder, "stories");
        try {
            this.storiesFolder.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File[] files = storiesFolder.listFiles(new JsonFileFilter());
        for(File json : files) {
            try {
                this.stories.add(this.storyManager.createStory(new FileReader(json)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<IStory> getStoriesByTitle(String title) {
        return this.stories.stream().filter(story -> story.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<IStory> getStories() {
        return this.stories;
    }
}
