package com.project.LivreDeWalidou;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.provider.SyncStateContract;
import android.util.Log;

import com.project.LivreDeWalidou.model.AppFolder;
import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.manager.StoryManager;
import com.project.LivreDeWalidou.model.manager.StoryManagerJson;
import com.project.LivreDeWalidou.model.repository.IStoryRepository;
import com.project.LivreDeWalidou.model.repository.StoryRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.Arrays;

public class App extends Application {

    public App() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        IStoryRepository sr = new StoryRepository(new AppFolder(this).getStoriesFolder());
        StoryManager sm = new StoryManagerJson();
        IStory story;
        try {
            for(String file : this.getAssets().list("stories")) {
                story = sm.createStory(new InputStreamReader(this.getAssets().open("stories/"+file)));
                sr.addStory(story);
            }
            File imagesFolder = new AppFolder(this).getImagesFolder();
            imagesFolder.mkdirs();
            File img;
            Log.d("LOCALES", Arrays.toString(this.getAssets().list("stories_img")));
            for(String file : this.getAssets().list("stories_img")) {
                img = new File(imagesFolder, file);
                if(img.exists()) img.delete();
                Files.copy(this.getAssets().open("stories_img/"+file), new File(imagesFolder, file).toPath());
                Log.d("COPY FILE", String.valueOf(new File(imagesFolder, file).toURI().toString()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}