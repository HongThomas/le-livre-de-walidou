package com.android.LivreDeWalidou.model;

import com.android.LivreDeWalidou.model.comp.Choice;
import com.android.LivreDeWalidou.model.comp.Page;

public interface IGame {
    void makeChoice(Choice choice);
    boolean isFinished();
    Page getCurrentPage();
    IStory getStory();
}
