package com.android.LivreDeWalidou.model.comp;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class PageAdapter implements JsonSerializer<Page>, JsonDeserializer<Page> {

    @Override
    public Page deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(Page src, Type typeOfSrc, JsonSerializationContext context) {

        return null;
    }
}
