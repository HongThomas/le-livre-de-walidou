package com.project.LivreDeWalidou.model.manager;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import com.project.LivreDeWalidou.model.IStory;
import com.project.LivreDeWalidou.model.comp.IStoryItem;
import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.project.LivreDeWalidou.model.comp.StoryText;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;

public class IStoryItemAdapter implements JsonDeserializer<IStoryItem>, JsonSerializer<IStoryItem> {
    @Override
    public IStoryItem deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        int id = o.get("type").getAsInt();
        JsonObject content = o.getAsJsonObject("content");
        switch (StoryItemType.getTypeById(id)) {
            case IMAGE:
                try {
                    return new StoryImage(new URI(content.get("path").getAsString()));
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }
            case TEXTE:
                return new StoryText(content.get("text").getAsString());
            default:
                return new StoryText("");
        }
    }

    @Override
    public JsonElement serialize(IStoryItem src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty("type", StoryItemType.getTypeByClass(src.getClass()).getId());
        json.add("content", context.serialize(src, src.getClass()));
        return json;
    }
}
