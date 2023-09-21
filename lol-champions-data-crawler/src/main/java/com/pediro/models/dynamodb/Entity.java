package com.pediro.models.dynamodb;

public class Entity {
    
    private String name;
    private String coverImage;
    private String description;
    private int price;
    private String thumbnailImage;
    private String[] tags;    
    private int difficulty; 

    public Entity(String name, String coverImage, String description, String thumbnailImage, int price, String[] tags, int difficulty) {
        this.name = name;
        this.coverImage = coverImage;
        this.description = description;
        this.thumbnailImage = thumbnailImage;
        this.price = price;
        this.tags = tags;
        this.difficulty = difficulty;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverImage() {
        return this.coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getThumbnailImage() {
        return this.thumbnailImage;
    }

    public void setThumbnailImage(String thumbnailImage) {
        this.thumbnailImage = thumbnailImage;
    }
    
    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }
}
