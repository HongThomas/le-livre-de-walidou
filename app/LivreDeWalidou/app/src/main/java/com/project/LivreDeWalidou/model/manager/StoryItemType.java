package com.project.LivreDeWalidou.model.manager;

import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.project.LivreDeWalidou.model.comp.StoryText;

public enum StoryItemType {
    IMAGE(0, StoryImage.class),
    TEXTE(1, StoryText.class);

    public int getId() {
        return this.id;
    }

    public Class<?> getClazz() {
        return this.clazz;
    }

    private int id;
    private Class<?> clazz;

    StoryItemType(int id, Class<?> clazz) {
        this.id = id;
        this.clazz = clazz;
    }

    public static StoryItemType getTypeById(int id) {
        for(StoryItemType type : StoryItemType.values()) {
            if(type.id == id) return type;
        }
        return null;
    }

    public static <T> StoryItemType getTypeByClass(T clazz) {
        for(StoryItemType type : StoryItemType.values()) {
            if(type.clazz == clazz) return type;
        }
        return null;
    }


}
