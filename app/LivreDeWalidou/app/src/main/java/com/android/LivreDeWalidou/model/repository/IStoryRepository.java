package com.android.LivreDeWalidou.model.repository;

import com.android.LivreDeWalidou.model.IStory;
import com.android.LivreDeWalidou.model.Story;

import java.util.List;

public interface IStoryRepository {
    List<IStory> getStoriesByTitle(String title);
    List<IStory> getStories();
}
