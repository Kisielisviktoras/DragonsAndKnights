package com.dak.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Class representing knight entity
 * @author Saji
 */
public class Knight implements Trainable {
    private String name;
    private Attribute attack;
    private Attribute armor;
    private Attribute agility;
    private Attribute endurance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Attribute getAttack() {
        return attack;
    }

    public void setAttack(Attribute attack) {
        this.attack = attack;
    }

    public Attribute getArmor() {
        return armor;
    }

    public void setArmor(Attribute armor) {
        this.armor = armor;
    }

    public Attribute getAgility() {
        return agility;
    }

    public void setAgility(Attribute agility) {
        this.agility = agility;
    }

    public Attribute getEndurance() {
        return endurance;
    }

    public void setEndurance(Attribute endurance) {
        this.endurance = endurance;
    }

    @Override
    public String toString() {
        return "Knight{" +
                attack.getType().getName() +"="+attack.getValue()+", "+
                armor.getType().getName() +"="+armor.getValue()+", "+
                agility.getType().getName() +"="+agility.getValue()+", "+
                endurance.getType().getName() +"="+endurance.getValue()+", "+
                '}';
    }

    @Override
    public int getUsedAttributePoints() {
        return attack.getValue() + armor.getValue() + agility.getValue() + endurance.getValue();
    }

    @Override
    public List<Attribute> getAttributes() {
        return Arrays.asList(agility, attack, armor, endurance);
    }
}
