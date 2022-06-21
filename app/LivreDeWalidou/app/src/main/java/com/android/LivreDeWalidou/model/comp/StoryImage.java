package com.android.LivreDeWalidou.model.comp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;

import java.io.IOException;
import java.net.URI;
import java.net.URL;

public class StoryImage implements IStoryItem<Bitmap> {

    @Expose(serialize = false, deserialize = false)
    private Bitmap content;

    private URI path;

    public StoryImage(URI uri) {
        this.path = uri;
        this.initBitmap();
    }

    private void initBitmap() {
        try {
            this.content = BitmapFactory.decodeStream(this.path.toURL().openStream());
        } catch (IOException e) {
            this.content = Bitmap.createBitmap(0, 0, Bitmap.Config.HARDWARE);
        }
    }

    @Override
    public Bitmap getContent() {
        return this.content;
    }

    public URI getURI() {
        return this.path;
    }
}
