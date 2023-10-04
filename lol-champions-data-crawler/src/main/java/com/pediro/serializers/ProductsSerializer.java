package com.pediro.serializers;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.pediro.models.dynamodb.Entity;
import com.pediro.models.dynamodb.Products;;

public class ProductsSerializer extends StdSerializer<Products> {

    public ProductsSerializer() {
        this(null);
    }

    public ProductsSerializer(Class<Products> t) {
        super(t);
    }

    @Override
    public void serialize(Products products, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
            gen.writeArrayFieldStart("products");
            for(Entity entity : products.getEntities()) {
                gen.writeStartObject();
                    gen.writeObjectFieldStart("PutRequest");
                        gen.writeObjectFieldStart("Item");
                            WriteJsonString(gen, "name", entity.getName().toLowerCase());
                            gen.writeObjectFieldStart("tags");
                                gen.writeFieldName("SS");
                                gen.writeArray(entity.getTags(), 0, entity.getTags().length);
                            gen.writeEndObject();
                            WriteJsonString(gen, "coverImage", entity.getCoverImage());
                            WriteJsonString(gen, "thumbnailImage", entity.getThumbnailImage());
                            WriteJsonString(gen, "description", entity.getDescription());
                            WriteJsonString(gen, "difficult", String.valueOf(entity.getDifficulty()));
                            WriteJsonString(gen, "price", String.valueOf(entity.getPrice()));
                        gen.writeEndObject();
                    gen.writeEndObject();
                gen.writeEndObject();
            }
            gen.writeEndArray();
        gen.writeEndObject();
    }

    private void WriteJsonString(JsonGenerator gen, String fieldName, String value) throws IOException {
        gen.writeObjectFieldStart(fieldName);
            gen.writeStringField("S", value);
        gen.writeEndObject();
    }
}
