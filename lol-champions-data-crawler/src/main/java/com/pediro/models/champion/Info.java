package com.pediro.models.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Info {    

    @JsonProperty("attack")
    private double Attack;
    
    @JsonProperty("defense")
    private double Defence;
    
    @JsonProperty("magic")
    private double Magic;
    
    @JsonProperty("difficulty")
    private int Difficulty;

    public double getAttack() {
        return this.Attack;
    }

    public double getDefence() {
        return this.Defence;
    }

    public double getMagic() {
        return this.Magic;
    }

    public int getDifficulty() {
        return this.Difficulty;
    }

}
