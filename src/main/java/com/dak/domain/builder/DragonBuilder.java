package com.dak.domain.builder;

import com.dak.domain.Attribute;
import com.dak.domain.Dragon;
import com.dak.domain.constants.AttributeTypeEnum;

public class DragonBuilder {
    private Attribute scaleThickness;
    private Attribute clawSharpness;
    private Attribute wingStrength;
    private Attribute fireBreath;

    public static DragonBuilder getBuilder() {
        return new DragonBuilder();
    }

    public DragonBuilder setScaleThickness(Integer scaleThickness) {
        this.scaleThickness = new Attribute(AttributeTypeEnum.SCALE_THICKNESS, scaleThickness);
        return this;
    }

    public DragonBuilder setClawSharpness(Integer clawSharpness) {
        this.clawSharpness = new Attribute(AttributeTypeEnum.CLAW_SHARPNESS, clawSharpness);
        return this;
    }

    public DragonBuilder setWingStrength(Integer wingStrength) {
        this.wingStrength = new Attribute(AttributeTypeEnum.WING_STRENGTH, wingStrength);
        return this;
    }

    public DragonBuilder setFireBreath(Integer fireBreath) {
        this.fireBreath = new Attribute(AttributeTypeEnum.FIRE_BREATH, fireBreath);
        return this;
    }

    public Dragon createDragon() {
        Dragon dragon = new Dragon();
        dragon.setScaleThickness(scaleThickness);
        dragon.setClawSharpness(clawSharpness);
        dragon.setWingStrength(wingStrength);
        dragon.setFireBreath(fireBreath);
        return dragon;
    }
}