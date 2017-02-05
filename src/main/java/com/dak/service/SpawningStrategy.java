package com.dak.service;

import com.dak.domain.constants.WeatherCodeEnum;

/**
 * Implementation should define unit breeding strategy based on weather
 * @author Saji
 */
public interface SpawningStrategy<F, E> {

    /**
     *
     * @param weatherCodeEnum
     * @return
     */
    boolean isApplicable(WeatherCodeEnum weatherCodeEnum);

    /**
     * Spawn friendly unit to fight against enemy
     * @param enemy
     * @return friendly unit
     */
    F spawn(E enemy);

}
