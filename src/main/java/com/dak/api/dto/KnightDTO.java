package com.dak.api.dto;

import java.io.Serializable;

/**
 * @author Saji
 */
public class KnightDTO implements Serializable {
    private String name;
    private Integer attack;
    private Integer armor;
    private Integer agility;
    private Integer endurance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getArmor() {
        return armor;
    }

    public void setArmor(Integer armor) {
        this.armor = armor;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getEndurance() {
        return endurance;
    }

    public void setEndurance(Integer endurance) {
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return "KnightDTO{" +
                "name='" + name + '\'' +
                ", attack=" + attack +
                ", armor=" + armor +
                ", agility=" + agility +
                ", endurance=" + endurance +
                '}';
    }
}
