package com.project.LivreDeWalidou.model.repository;

import android.util.Log;

import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.manager.StoryManager;
import com.project.LivreDeWalidou.model.manager.StoryManagerJson;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StoryRepository implements IStoryRepository {
    private List<IStory> stories;
    private StoryManager storyManager;
    private File storiesFolder;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public StoryRepository(File storiesFolder) {
        this.stories = new ArrayList<>();
        this.storyManager = new StoryManagerJson();
        this.storiesFolder = storiesFolder;

        Log.d("CREATION DOSSIER", String.valueOf(this.storiesFolder.mkdirs()));

        File[] files = this.storiesFolder.listFiles(new JsonFileFilter());
        for(File json : files) {
            try {
                this.stories.add(this.storyManager.createStory(new FileReader(json)));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        this.pcs.firePropertyChange("stories", this.stories, this.stories);
    }

    public List<IStory> getStoriesByTitle(String title) {
        return this.stories.stream().filter(story -> story.getTitle().equals(title)).collect(Collectors.toList());
    }

    @Override
    public List<IStory> getStories() {
        return this.stories;
    }

    @Override
    public void addStory(IStory story) {
        File storySaveFile = new File(this.storiesFolder, story.getTitle().getContent()+".json");
        try {
            storySaveFile.createNewFile();
            this.storyManager.saveStory(
                    new FileWriter(storySaveFile),
                    story
            );
            this.stories.add(story);
            this.pcs.firePropertyChange("stories", this.stories, this.stories);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(property, listener);
    }

    @Override
    public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
        this.removePropertyChangeListener(property, listener);
    }
}
