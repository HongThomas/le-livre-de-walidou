package com.project.LivreDeWalidou.viewmodel;

import android.app.Application;
import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.project.LivreDeWalidou.model.AppFolder;
import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.repository.IStoryRepository;
import com.project.LivreDeWalidou.model.repository.StoryRepository;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class StoriesViewModel extends AndroidViewModel implements PropertyChangeListener {
    public List<Bitmap> backgrounds;
    private List<IStory> stories;
    private AppFolder appFolder;
    private IStoryRepository storyRepository;

    public StoriesViewModel(@NonNull Application application) {
        super(application);
        this.appFolder = new AppFolder(application);
        this.storyRepository = new StoryRepository(this.appFolder.getStoriesFolder());
        this.storyRepository.addPropertyChangeListener("stories", this);
        this.stories = this.storyRepository.getStories();
    }

    private void refreshBitmap() {
        this.backgrounds = new ArrayList<>();
        this.stories.stream().forEach(story -> this.backgrounds.add(story.getBackground().getContent()));
    }

    private void refreshStories() {
        this.stories = this.storyRepository.getStories();
    }

    @Override
    public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
        this.refreshStories();
        this.refreshBitmap();
    }
}