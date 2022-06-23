package com.project.LivreDeWalidou.model;

import android.app.Application;
import android.os.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppFolder {

    private Application context;

    public AppFolder(Application app) {
        this.context = app;
    }
    public File getGamesFolder() {
        return new File(this.context.getDataDir(), "games");
    }

    public File getStoriesFolder() {
        return new File(this.context.getDataDir(), "stories");
    }

    public File getImagesFolder() {
        return new File(this.context.getDataDir(), "images");
    }
}
