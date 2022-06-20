package com.android.LivreDeWalidou.model.comp;

public class Choice {
    private StoryText text;
    private Page suiteHistoire;

    public Choice(Page suiteHistoire, StoryText choiceText) {
        this.suiteHistoire = suiteHistoire;
        this.text = choiceText;
    }

    public Page getFollowingPage() {
        return this.suiteHistoire;
    }

    public StoryText getText() {
        return this.text;
    }
}
