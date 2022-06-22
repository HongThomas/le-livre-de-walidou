package com.project.LivreDeWalidou.model.comp;

public class StoryText implements IStoryItem<String> {
    private String text;

    public StoryText(String text) {
        this.text = text;
    }

    @Override
    public String getContent() {
        return this.text;
    }
}
