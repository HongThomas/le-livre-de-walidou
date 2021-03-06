package com.project.LivreDeWalidou.viewmodel;

import android.app.Application;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.project.LivreDeWalidou.IPropertyChangeProvider;
import com.project.LivreDeWalidou.model.AppFolder;
import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.repository.GameRepository;
import com.project.LivreDeWalidou.model.repository.IStoryRepository;
import com.project.LivreDeWalidou.model.repository.StoryRepository;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class NewGameViewModel extends AndroidViewModel implements PropertyChangeListener {
    private List<IStory> stories;
    private AppFolder appFolder;
    private IStoryRepository storyRepository;

    public NewGameViewModel(@NonNull Application application) {
        super(application);
        this.appFolder = new AppFolder(application);
        this.storyRepository = new StoryRepository(this.appFolder.getStoriesFolder());
        this.storyRepository.addPropertyChangeListener("stories", this);
        this.stories = this.storyRepository.getStories();
    }
    private void refreshStories() {
        this.stories = this.storyRepository.getStories();
    }

    public List<IStory> getStories() {
        return this.stories;
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        this.refreshStories();
    }
}
