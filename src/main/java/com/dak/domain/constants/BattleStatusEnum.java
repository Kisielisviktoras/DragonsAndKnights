package com.dak.domain.constants;

/**
 * @author Saji
 */
public enum BattleStatusEnum {
    DEFEAT,
    VICTORY;

    public static BattleStatusEnum of(String value) {
        for (BattleStatusEnum battleStatusEnum : values()) {
            if (battleStatusEnum.name().equalsIgnoreCase(value)) {
                return battleStatusEnum;
            }
        }
        throw new IllegalArgumentException(String.format("Unknown enum value %s", value));
    }
}
