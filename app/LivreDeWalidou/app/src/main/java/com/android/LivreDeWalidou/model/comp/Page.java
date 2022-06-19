package com.android.LivreDeWalidou.model.comp;

import com.android.LivreDeWalidou.model.repository.IStoryItem;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Page {
    private final List<IStoryItem<?>> items;
    private final List<Choice> choices;

    public Page() {
        this.items = new ArrayList<>();
        this.choices = new ArrayList<>();
    }

    public Page addItem(IStoryItem<?> item) {
        this.items.add(item);
        return this;
    }

    public Page addChoice(Choice choice) {
        this.choices.add(choice);
        return this;
    }

    public Page deleteItem(IStoryItem<?> item) {
        this.items.remove(item);
        return this;
    }

    public Page deleteChoice(Choice choice) {
        this.choices.add(choice);
        return this;
    }

    public List<Choice> getChoices() {
        return this.choices;
    }

    public List<IStoryItem<?>> getItems() {
        return this.items;
    }
}
