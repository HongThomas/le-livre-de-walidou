package com.android.LivreDeWalidou.model.comp;

public class Choice {
    private Page suiteHistoire;
    private StoryText text;

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
