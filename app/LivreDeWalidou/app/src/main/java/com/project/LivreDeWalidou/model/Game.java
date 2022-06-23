package com.project.LivreDeWalidou.model;

import com.google.gson.annotations.Expose;
import com.project.LivreDeWalidou.IPropertyChangeProvider;
import com.project.LivreDeWalidou.model.comp.Choice;
import com.project.LivreDeWalidou.model.comp.IStoryItem;
import com.project.LivreDeWalidou.model.comp.Page;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.project.LivreDeWalidou.model.comp.StoryText;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Game implements IGame, IPropertyChangeProvider {

    private final Story story;

    @Expose(serialize = false, deserialize = false)
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    private Page state;

    public Game(IStory associatedStory, Page state) {
        this.story = (Story) associatedStory;
        this.state = state;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
    }

    @Override
    public void addPropertyChangeListener(String property, PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(property, listener);
    }

    @Override
    public void removePropertyChangeListener(String property, PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(property, listener);
    }

    @Override
    public void makeChoice(Choice choice) {
        Page oldState = this.state;
        this.state = choice.getFollowingPage();
        this.pcs.firePropertyChange("state", oldState, this.state);
    }

    @Override
    public Page getCurrentPage() {
        return this.state;
    }

    @Override
    public boolean isFinished() {
        return this.state.getItems().size() == 0;
    }

    public IStory getStory() {
        return this.story;
    }
}
