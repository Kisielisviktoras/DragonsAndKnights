package com.dak.service;

import com.dak.domain.constants.WeatherCodeEnum;

/**
 * Implementation should define unit breeding strategy based on weather
 *
 * @author Saji
 */
public interface SpawningStrategy<F, E> {

    /**
     * Check if rule is applicable in given context
     * @param weatherCodeEnum describes weather conditions
     * @return true if rule should be applied, false if not
     */
    boolean isApplicable(WeatherCodeEnum weatherCodeEnum);

    /**
     * Spawn friendly unit to fight against enemy
     * @param enemy unit to battle with
     * @return friendly unit
     */
    F spawn(E enemy);

}
