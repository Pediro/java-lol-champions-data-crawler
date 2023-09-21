package com.pediro.models.champion;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Stats {
    
    @JsonProperty("hp")
    private double Health;
    
    @JsonProperty("hpperlevel")
    private double HealthPerLevel;
    
    @JsonProperty("mp")
    private double ManaPoint;
    
    @JsonProperty("mpperlevel")
    private double ManaPointPerLevel;
    
    @JsonProperty("movespeed")
    private double MoveSpeed;
    
    @JsonProperty("armor")
    private double Armour;
    
    @JsonProperty("armorperlevel")
    private double ArmourPerLevel;
    
    @JsonProperty("spellblock")
    private double SpellBlock;
    
    @JsonProperty("spellblockperlevel")
    private double SpellBlockPerLevel;
    
    @JsonProperty("attackrange")
    private double AttackRange;

    @JsonProperty("hpregen")
    private double HealthRegen;
    
    @JsonProperty("hpregenperlevel")
    private double HealthRegenPerLevel;
    
    @JsonProperty("mpregen")
    private double ManaRegen;
    
    @JsonProperty("mpregenperlevel")
    private double ManaRegenPerLevel;
    
    @JsonProperty("crit")
    private double Crit;
    
    @JsonProperty("critperlevel")
    private double CritPerLevel;
    
    @JsonProperty("attackdamage")
    private double AttackDamage;
    
    @JsonProperty("attackdamageperlevel")
    private double AttackDamagePerLevel;
    
    @JsonProperty("attackspeed")
    private double AttackSpeed;
    
    @JsonProperty("attackspeedperlevel")
    private double AttackSpeedPerLevel;

    public double getHealth() {
        return this.Health;
    }

    public double getHealthPerLevel() {
        return this.HealthPerLevel;
    }

    public double getManaPoint() {
        return this.ManaPoint;
    }

    public double getManaPointPerLevel() {
        return this.ManaPointPerLevel;
    }

    public double getMoveSpeed() {
        return this.MoveSpeed;
    }

    public double getArmour() {
        return this.Armour;
    }

    public double getArmourPerLevel() {
        return this.ArmourPerLevel;
    }

    public double getSpellBlock() {
        return this.SpellBlock;
    }

    public double getSpellBlockPerLevel() {
        return this.SpellBlockPerLevel;
    }

    public double getAttackRange() {
        return this.AttackRange;
    }

    public double getHealthRegen() {
        return this.HealthRegen;
    }

    public double getHealthRegenPerLevel() {
        return this.HealthRegenPerLevel;
    }

    public double getManaRegen() {
        return this.ManaRegen;
    }

    public double getManaRegenPerLevel() {
        return this.ManaRegenPerLevel;
    }

    public double getCrit() {
        return this.Crit;
    }

    public double getCritPerLevel() {
        return this.CritPerLevel;
    }

    public double getAttackDamage() {
        return this.AttackDamage;
    }

    public double getAttackDamagePerLevel() {
        return this.AttackDamagePerLevel;
    }

    public double getAttackSpeed() {
        return this.AttackSpeed;
    }

    public double getAttackSpeedPerLevel() {
        return this.AttackSpeedPerLevel;
    }
}
