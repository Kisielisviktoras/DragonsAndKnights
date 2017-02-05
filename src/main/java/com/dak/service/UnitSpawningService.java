package com.dak.service;

import com.dak.domain.Attribute;
import com.dak.domain.Trainable;
import com.dak.domain.constants.WeatherCodeEnum;

import java.util.List;

/**
 * @author Saji
 */
public class UnitSpawningService<F extends Trainable, E extends Trainable> implements SpawningService<F, E> {

    private final int MIN_ATTRIBUTE;
    private final int MAX_ATTRIBUTE;
    private final int TOTAL_POINTS;
    private List<SpawningStrategy<F, E>> strategies;


    public UnitSpawningService(int totalAttributePoints, int minAttributePoints, int maxAttributePoint, List<SpawningStrategy<F, E>> strategies) {
        this.MIN_ATTRIBUTE = minAttributePoints;
        this.MAX_ATTRIBUTE = maxAttributePoint;
        this.TOTAL_POINTS = totalAttributePoints;
        this.strategies = strategies;
    }

    public F spawn(E enemy, WeatherCodeEnum weatherCode) {
        F friendUnit = null;
        for (SpawningStrategy<F, E> strategy : strategies) {
            if (strategy.isApplicable(weatherCode)) {
                friendUnit = strategy.spawn(enemy);
                break;
            }
        }

        if (friendUnit != null) {
            validatedSpawnedUnit(friendUnit);
        }

        return friendUnit;
    }

    private void validatedSpawnedUnit(F friendlyUnit) {
        int usedPoints = friendlyUnit.getUsedAttributePoints();
        if (usedPoints != TOTAL_POINTS) {
            throw new IllegalStateException(String.format("%s point(s) should be used, cannot create unit with %s points", TOTAL_POINTS, usedPoints));
        }

        for (Attribute attribute : friendlyUnit.getAttributes()) {
            validateStat(attribute);
        }

    }

    private void validateStat(Attribute attribute) {
        if (MAX_ATTRIBUTE < attribute.getValue() || MIN_ATTRIBUTE > attribute.getValue()) {
            throw new IllegalStateException(String.format("[%s] is\\are used on attribute [%s], allowed range is from %s to %s",
                    attribute.getValue(), attribute.getType().getName(), MIN_ATTRIBUTE, MAX_ATTRIBUTE));
        }
    }
}
