package com.pediro.models.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Image {
    
    @JsonProperty("full")
    private String full;
    
    @JsonProperty("sprite")
    private String sprite;
    
    @JsonProperty("group")
    private String group;
    
    @JsonProperty("x")
    private int x;
    
    @JsonProperty("y")
    private int y;
    
    @JsonProperty("w")
    private int w;
    
    @JsonProperty("h")
    private int h;


    public String getFull() {
        return this.full;
    }
    
    public String getSprite() {
        return this.sprite;
    }
    
    public String getGroup() {
        return this.group;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getW() {
        return this.w;
    }

    public int getH() {
        return this.h;
    }
}
