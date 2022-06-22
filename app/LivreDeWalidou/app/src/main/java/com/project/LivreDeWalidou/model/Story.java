package com.project.LivreDeWalidou.model;

import com.project.LivreDeWalidou.model.comp.Page;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.project.LivreDeWalidou.model.comp.StoryText;

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
