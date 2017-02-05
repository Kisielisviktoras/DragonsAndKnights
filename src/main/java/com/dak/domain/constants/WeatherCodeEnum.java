package com.dak.domain.constants;

/**
 * @author Saji
 */
public enum WeatherCodeEnum {
    NORMAL("NMR"),
    RAIN("HVA"),
    DRY("T E"),
    FOG("FUNDEFINEDG"),
    STORM("SRO");

    private String value;

    WeatherCodeEnum(String value) {
        this.value = value;
    }

    public static WeatherCodeEnum of(String of) {
        for (WeatherCodeEnum weatherCodeEnum : values()) {
            if (weatherCodeEnum.value.equalsIgnoreCase(of)) {
                return weatherCodeEnum;
            }
        }
        throw new IllegalArgumentException("Unknown enum value passed");
    }
}
