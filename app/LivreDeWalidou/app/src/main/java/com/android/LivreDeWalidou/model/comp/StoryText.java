package com.android.LivreDeWalidou.model.comp;

public class StoryText implements IStoryItem<String> {
    private String content;

    public StoryText(String text) {
        this.content = text;
    }

    @Override
    public String getContent() {
        return this.content;
    }
}
