package com.project.LivreDeWalidou.model.manager;

import android.util.Log;

import com.project.LivreDeWalidou.model.comp.StoryImage;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

public class StoryImageAdapter implements JsonSerializer<StoryImage>, JsonDeserializer<StoryImage> {

    @Override
    public StoryImage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject o = json.getAsJsonObject();
        try {
            return new StoryImage(new URI(o.get("path").getAsString()));
        } catch (URISyntaxException e) {
           Log.d("ERROR: ", Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    @Override
    public JsonElement serialize(StoryImage src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject json = new JsonObject();
        json.addProperty("path", src.getURI().toString());
        return json;
    }
}
