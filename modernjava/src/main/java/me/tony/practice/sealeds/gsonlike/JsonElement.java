package me.tony.practice.sealeds.gsonlike;

public abstract sealed class JsonElement permits JsonArray, JsonNull, JsonPrimitive, JsonObject {
}
