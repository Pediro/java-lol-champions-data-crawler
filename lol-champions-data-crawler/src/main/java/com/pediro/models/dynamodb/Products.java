package com.pediro.models.dynamodb;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.pediro.serializers.ProductsSerializer;

public class Products {
    
    @JsonSerialize(using = ProductsSerializer.class)
    private List<Entity> products;


    public Products(List<Entity> products) {
        this.products = products;
    }

    public List<Entity> getEntities() {
        return this.products;
    }

}
