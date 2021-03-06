package com.project.LivreDeWalidou.model.repository;

import com.project.LivreDeWalidou.IPropertyChangeProvider;
import com.project.LivreDeWalidou.model.IStory;

import java.util.List;

public interface IStoryRepository extends IPropertyChangeProvider {
    List<IStory> getStoriesByTitle(String title);
    void addStory(IStory story);
    List<IStory> getStories();
}
