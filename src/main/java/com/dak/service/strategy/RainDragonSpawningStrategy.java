package com.dak.service.strategy;

import com.dak.domain.Dragon;
import com.dak.domain.Knight;
import com.dak.domain.builder.DragonBuilder;
import com.dak.domain.constants.WeatherCodeEnum;
import com.dak.service.SpawningStrategy;

import java.util.EnumSet;

/**
 * @author Saji
 */
public class RainDragonSpawningStrategy implements SpawningStrategy<Dragon, Knight> {

    private final EnumSet<WeatherCodeEnum> APPLICABLE_WEATHER = EnumSet.of(WeatherCodeEnum.RAIN);

    @Override
    public boolean isApplicable(WeatherCodeEnum weatherCodeEnum) {
        return APPLICABLE_WEATHER.contains(weatherCodeEnum);
    }

    @Override
    public Dragon spawn(Knight enemy) {
        return DragonBuilder.getBuilder().setWingStrength(5).setClawSharpness(10).setScaleThickness(5).setFireBreath(0).createDragon();
    }
}
