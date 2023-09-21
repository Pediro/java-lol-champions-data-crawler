package com.pediro.models.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {

    @JsonProperty("version")
    private String version;
    
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("key")
    private String key;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("title")
    private String title;
    
    @JsonProperty("blurb")
    private String blurb;
    
    @JsonProperty("info")
    private Info info;
    
    @JsonProperty("image")
    private Image image;
    
    @JsonProperty("tags")
    private String[] tags;
    
    @JsonProperty("partype")
    private String partype;
    
    @JsonProperty("stats")
    private Stats stats;

    public String getVersion() {
        return this.version;
    }

    public String getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public String getTitle() {
        return this.title;
    }

    public String getBlurb() {
        return this.blurb;
    }

    public Info getInfo() {
        return this.info;
    }

    public Image getImage() {
        return this.image;
    }

    public String[] getTags() {
        return this.tags;
    }

    public String getPartype() {
        return this.partype;
    }

    public Stats getStats() {
        return this.stats;
    }
}
