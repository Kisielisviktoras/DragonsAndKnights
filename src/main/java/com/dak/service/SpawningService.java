package com.dak.service;

import com.dak.domain.constants.WeatherCodeEnum;

/**
 * Interface for unit spawning services
 *
 * @author Saji
 */
public interface SpawningService<F, E> {

    int MAX_STAT = 10;

    /**
     * Spawn friendly unit to fight enemy
     *
     * @param enemy to fight
     * @return built friendly unit
     */
    F spawn(E enemy, WeatherCodeEnum weatherCodeEnum);

}
