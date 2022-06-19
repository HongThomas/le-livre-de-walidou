package com.android.LivreDeWalidou.model;

import com.android.LivreDeWalidou.model.comp.Page;
import com.android.LivreDeWalidou.model.comp.StoryImage;
import com.android.LivreDeWalidou.model.comp.StoryText;

import java.beans.PropertyChangeListener;
import java.util.EventListener;
import java.util.EventListenerProxy;

public class Story implements IStory {

    private final Page introduction;
    private final StoryText title;
    private final StoryImage background;

    public Story(Page introduction, StoryText title, StoryImage background) {
        this.introduction = introduction;
        this.title = title;
        this.background = background;
    }

    @Override
    public Page getFirstPage() {
        return this.introduction;
    }

    @Override
    public StoryText getTitle() {
        return this.title;
    }

    @Override
    public StoryImage getBackground() {
        return this.background;
    }

}
