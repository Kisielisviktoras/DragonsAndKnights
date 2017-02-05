package com.dak.api.dto;

import java.io.Serializable;

/**
 * @author Saji
 */
public class DragonDTO implements Serializable {

    private Integer scaleThickness;
    private Integer clawSharpness;
    private Integer wingStrength;
    private Integer fireBreath;

    public Integer getScaleThickness() {
        return scaleThickness;
    }

    public void setScaleThickness(Integer scaleThickness) {
        this.scaleThickness = scaleThickness;
    }

    public Integer getClawSharpness() {
        return clawSharpness;
    }

    public void setClawSharpness(Integer clawSharpness) {
        this.clawSharpness = clawSharpness;
    }

    public Integer getWingStrength() {
        return wingStrength;
    }

    public void setWingStrength(Integer wingStrength) {
        this.wingStrength = wingStrength;
    }

    public Integer getFireBreath() {
        return fireBreath;
    }

    public void setFireBreath(Integer fireBreath) {
        this.fireBreath = fireBreath;
    }
}
