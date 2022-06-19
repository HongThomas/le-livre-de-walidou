package com.android.LivreDeWalidou.model.comp;

import android.graphics.Bitmap;

import com.android.LivreDeWalidou.model.repository.IStoryItem;

public class StoryImage implements IStoryItem<Bitmap> {

    private Bitmap content;

    public StoryImage(Bitmap bm) {
        this.content = bm;
    }

    @Override
    public Bitmap getContent() {
        return this.content;
    }
}
