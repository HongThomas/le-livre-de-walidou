package com.project.LivreDeWalidou.model.comp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;

import com.google.gson.annotations.Expose;

import java.net.URI;

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
        } catch (Exception e) {
            this.content = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
            this.content.eraseColor(Color.TRANSPARENT);
        }
    }

    @Override
    public Bitmap getContent() {
        if(this.content == null) this.initBitmap();
        return this.content;
    }

    public URI getURI() {
        return this.path;
    }
}
