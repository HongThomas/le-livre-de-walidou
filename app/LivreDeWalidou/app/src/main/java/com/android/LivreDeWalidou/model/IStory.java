package com.android.LivreDeWalidou.model;

import com.android.LivreDeWalidou.model.comp.Page;
import com.android.LivreDeWalidou.model.comp.StoryImage;
import com.android.LivreDeWalidou.model.comp.StoryText;

public interface IStory {
    Page getFirstPage();
    StoryText getTitle();
    StoryImage getBackground();
}
