package com.android.LivreDeWalidou.model.comp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.annotations.Expose;

import java.io.IOException;
import java.net.URL;

public class StoryImage implements IStoryItem<Bitmap> {

    @Expose(serialize = false, deserialize = false)
    private String path;
    private Bitmap content;

    public StoryImage(URL url) {
        try {
            this.content = BitmapFactory.decodeStream(url.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(this.content == null) throw new IllegalArgumentException("Cannot create bitmap.");
        this.path = url.getPath();
    }

    @Override
    public Bitmap getContent() {
        return this.content;
    }
}
