package com.dak.domain.constants;

/**
 * @author Saji
 */
public enum AttributeTypeEnum {
    ATTACK("Attack"),
    ARMOR("Armor"),
    AGILITY("Agility"),
    ENDURANCE("Endurance"),
    CLAW_SHARPNESS("ClawSharpness"),
    SCALE_THICKNESS("ScaleThickness"),
    FIRE_BREATH("FireBreath"),
    WING_STRENGTH("WingStrength");

    private final String name;

    AttributeTypeEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
