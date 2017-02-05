package com.dak.service.strategy;

import com.dak.domain.Attribute;
import com.dak.domain.Dragon;
import com.dak.domain.Knight;
import com.dak.domain.builder.DragonBuilder;
import com.dak.domain.constants.WeatherCodeEnum;
import com.dak.service.SpawningStrategy;

import java.util.*;

/**
 * @author Saji
 */
public class NormalDragonSpawningStrategy implements SpawningStrategy<Dragon, Knight> {

    private static final int MIN_ATTRIBUTE = 0;
    private static final int MAX_ATTRIBUTE = 10;
    private static final int TOTAL_POINTS = 20;
    private static final EnumSet<WeatherCodeEnum> APPLICABLE_WEATHER = EnumSet.of(WeatherCodeEnum.NORMAL, WeatherCodeEnum.FOG, WeatherCodeEnum.STORM);

    @Override
    public boolean isApplicable(WeatherCodeEnum weatherCodeEnum) {

        return APPLICABLE_WEATHER.contains(weatherCodeEnum);
    }

    @Override
    public Dragon spawn(Knight enemy) {
        return buildKnightCounter(enemy);
    }

    private Dragon buildKnightCounter(Knight knight) {
        Dragon knightCounter = DragonBuilder.getBuilder()
                .setWingStrength(knight.getAgility().getValue())
                .setFireBreath(knight.getEndurance().getValue())
                .setScaleThickness(knight.getAttack().getValue())
                .setClawSharpness(knight.getArmor().getValue())
                .createDragon();

        List<Attribute> dragonAttributes = Arrays.asList(knightCounter.getClawSharpness(), knightCounter.getFireBreath(), knightCounter.getScaleThickness(), knightCounter.getWingStrength());
        Attribute highestAttribute = Collections.max(Arrays.asList(knightCounter.getClawSharpness(), knightCounter.getFireBreath(), knightCounter.getScaleThickness(), knightCounter.getWingStrength()), Comparator.comparing(a -> a.getValue()));

        int freePoints = 0;
        for (Attribute dragonAttribute : dragonAttributes) {
            freePoints += decreaseAttribute(dragonAttribute);
        }
        freePoints = maxOut(highestAttribute, freePoints);

        //Waste all free points, battle is won anyways
        while (freePoints > 0) {
            for (Attribute dragonAttribute : dragonAttributes) {
                freePoints += increaseAttribute(dragonAttribute);
                if (freePoints == 0) {
                    break;
                }
            }
        }
        return knightCounter;
    }

    private int maxOut(Attribute attribute, int freePoints) {
        while (freePoints > 0 && attribute.getValue() < MAX_ATTRIBUTE) {
            freePoints += increaseAttribute(attribute);
        }
        return freePoints;
    }

    private int increaseAttribute(Attribute attribute) {
        if (attribute.getValue() + 1 > MAX_ATTRIBUTE) {
            return 0;
        }
        attribute.setValue(attribute.getValue() + 1);
        return -1;
    }

    private int decreaseAttribute(Attribute attribute) {
        if (attribute.getValue() - 1 < MIN_ATTRIBUTE) {
            return 0;
        }
        attribute.setValue(attribute.getValue() - 1);
        return 1;
    }

    private void validateAttributePoints(Dragon dragon) {
        int usedPoints = dragon.getClawSharpness().getValue() + dragon.getFireBreath().getValue() + dragon.getWingStrength().getValue() + dragon.getScaleThickness().getValue();
        if (usedPoints != TOTAL_POINTS) {
            throw new IllegalStateException(String.format("%s points should be used, cannot create unit with %s points", TOTAL_POINTS, usedPoints));
        }

        validateStat(dragon.getClawSharpness());
        validateStat(dragon.getFireBreath());
        validateStat(dragon.getScaleThickness());
        validateStat(dragon.getWingStrength());

    }

    private void validateStat(Attribute attribute) {
        if (MAX_ATTRIBUTE < attribute.getValue() || MIN_ATTRIBUTE > attribute.getValue()) {
            throw new IllegalStateException(String.format("[%s] are used on attribute [%s], allowed range is from %s to %s ",
                    attribute.getValue(), attribute.getType().getName(), MIN_ATTRIBUTE, MAX_ATTRIBUTE));
        }
    }
}
