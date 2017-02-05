package com.dak.domain;

import java.util.Arrays;
import java.util.List;

/**
 * Class representing dragon entity in game
 *
 * @author Saji
 */
public class Dragon implements Trainable {

    private Attribute scaleThickness;
    private Attribute clawSharpness;
    private Attribute fireBreath;
    private Attribute wingStrength;

    public Attribute getScaleThickness() {
        return scaleThickness;
    }

    public void setScaleThickness(Attribute scaleThickness) {
        this.scaleThickness = scaleThickness;
    }

    public Attribute getClawSharpness() {
        return clawSharpness;
    }

    public void setClawSharpness(Attribute clawSharpness) {
        this.clawSharpness = clawSharpness;
    }

    public Attribute getFireBreath() {
        return fireBreath;
    }

    public void setFireBreath(Attribute fireBreath) {
        this.fireBreath = fireBreath;
    }

    public Attribute getWingStrength() {
        return wingStrength;
    }

    public void setWingStrength(Attribute wingStrength) {
        this.wingStrength = wingStrength;
    }

    @Override
    public String toString() {
        return "Dragon{" +
                clawSharpness.getType().getName() + "=" + clawSharpness.getValue() + ", " +
                scaleThickness.getType().getName() + "=" + scaleThickness.getValue() + ", " +
                wingStrength.getType().getName() + "=" + wingStrength.getValue() + ", " +
                fireBreath.getType().getName() + "=" + fireBreath.getValue() + ", " +
                '}';
    }

    @Override
    public int getUsedAttributePoints() {
        return scaleThickness.getValue() + clawSharpness.getValue() + fireBreath.getValue() + wingStrength.getValue();
    }

    @Override
    public List<Attribute> getAttributes() {
        return Arrays.asList(clawSharpness, scaleThickness, fireBreath, wingStrength);
    }
}
