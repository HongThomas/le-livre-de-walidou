package com.project.LivreDeWalidou.model.manager;

import com.project.LivreDeWalidou.model.IStory;
import com.google.gson.JsonIOException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public interface StoryManager {
    IStory createStory(InputStreamReader isr) throws IOException;
    void saveStory(OutputStreamWriter osw, IStory story) throws IOException;
}
