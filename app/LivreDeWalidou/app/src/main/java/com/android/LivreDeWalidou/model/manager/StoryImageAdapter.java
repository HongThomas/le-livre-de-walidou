package com.android.LivreDeWalidou.model.manager;

import com.android.LivreDeWalidou.model.comp.StoryImage;
import com.android.LivreDeWalidou.model.comp.StoryText;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class StoryImageAdapter implements JsonSerializer<StoryImage>, JsonDeserializer<StoryImage> {

    @Override
    public StoryImage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        try {
            return new StoryImage(new URI(o.get("path").getAsString()));
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public JsonElement serialize(StoryImage src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty("path", src.getURI().getPath());
        return json;
    }
}
