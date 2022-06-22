package com.project.LivreDeWalidou.model;

import com.project.LivreDeWalidou.model.comp.Page;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.project.LivreDeWalidou.model.comp.StoryText;

public interface IStory {
    Page getFirstPage();
    StoryText getTitle();
    StoryImage getBackground();
}
