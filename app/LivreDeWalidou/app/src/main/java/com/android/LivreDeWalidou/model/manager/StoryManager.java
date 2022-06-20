package com.android.LivreDeWalidou.model.manager;

import com.android.LivreDeWalidou.model.IStory;
import com.google.gson.JsonIOException;

import java.io.InputStreamReader;

public interface StoryManager {
    IStory createStory(InputStreamReader isr) throws JsonIOException;
}
