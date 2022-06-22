package com.project.LivreDeWalidou.model;

import com.project.LivreDeWalidou.model.comp.Choice;
import com.project.LivreDeWalidou.model.comp.Page;

public interface IGame {
    void makeChoice(Choice choice);
    boolean isFinished();
    Page getCurrentPage();
    IStory getStory();
}
