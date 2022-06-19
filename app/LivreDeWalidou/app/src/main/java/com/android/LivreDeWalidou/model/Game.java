package com.android.LivreDeWalidou.model;

import com.android.LivreDeWalidou.IPropertyChangeProvider;
import com.android.LivreDeWalidou.model.comp.Choice;
import com.android.LivreDeWalidou.model.comp.Page;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Game implements IGame, IPropertyChangeProvider {
    private final IStory story;
    private Page state;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Game(IStory associatedStory, Page state) {
        this.story = associatedStory;
        this.state = state;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        this.pcs.removePropertyChangeListener(listener);
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
