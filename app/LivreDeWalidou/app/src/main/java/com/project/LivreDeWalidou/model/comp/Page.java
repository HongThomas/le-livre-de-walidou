package com.project.LivreDeWalidou.model.comp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Page page = (Page) o;
        return this.items.equals(page.items) && this.choices.equals(page.choices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.items, this.choices);
    }
}
