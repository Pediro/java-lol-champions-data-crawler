package com.pediro.models.champion;

import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonResponse {
    
    @JsonProperty(value="type")
    private String type;

    @JsonProperty(value="format")
    private String format;
    
    @JsonProperty(value="version")
    private String version;
    
    @JsonProperty(value="data")
    private Map<String, Data> data;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFormat() {
        return this.format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getVersion() {
        return this.format;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Map<String, Data> getData() {
        return this.data;
    }
}
