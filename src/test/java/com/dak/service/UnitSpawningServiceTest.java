package com.dak.service;

import com.dak.domain.Attribute;
import com.dak.domain.Dragon;
import com.dak.domain.Knight;
import com.dak.domain.constants.AttributeTypeEnum;
import com.dak.domain.constants.WeatherCodeEnum;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Saji
 */
public class UnitSpawningServiceTest {

    private final String KNIGHT_NAME = "Hi, My name is Knight";

    @Test
    public void testShouldApplyApplicableStrategy() {
        SpawningStrategy<Knight, Dragon> spawningStrategy = createUpdateKnightStrategy(true, KNIGHT_NAME, 0, 0);
        UnitSpawningService<Knight, Dragon> testInstance = new UnitSpawningService<>(0, 0,0, Arrays.asList(spawningStrategy));
        Knight knight = testInstance.spawn(null, null);
        Assert.assertEquals(KNIGHT_NAME, knight.getName());
    }

    @Test
    public void testApplyOnlyApplicableStrategy() {
        SpawningStrategy<Knight, Dragon> spawningStrategy = createUpdateKnightStrategy(false, KNIGHT_NAME, 0, 0);
        UnitSpawningService<Knight, Dragon> testInstance = new UnitSpawningService<>(0, 0,0, Arrays.asList(spawningStrategy));
        Knight knight = testInstance.spawn(null, null);
        Assert.assertNull(knight);
    }

    @Test
    public void testShouldUseAllPoints() {
        SpawningStrategy<Knight, Dragon> spawningStrategy = createUpdateKnightStrategy(true, KNIGHT_NAME, 0, 0);
        UnitSpawningService<Knight, Dragon> testInstance = new UnitSpawningService<>(1, 0,1, Arrays.asList(spawningStrategy));
        try {
            Knight knight = testInstance.spawn(null, null);
            Assert.fail("Should use all points when creating a unit");
        } catch (IllegalStateException ex) {
            Assert.assertEquals("1 point(s) should be used, cannot create unit with 0 points", ex.getMessage());
        }
    }

    @Test
    public void testShouldValidateMaxPoints() {
        SpawningStrategy<Knight, Dragon> spawningStrategy = createUpdateKnightStrategy(true, KNIGHT_NAME, 2, 0);
        UnitSpawningService<Knight, Dragon> testInstance = new UnitSpawningService<>(2, 0,1, Arrays.asList(spawningStrategy));
        try {
            Knight knight = testInstance.spawn(null, null);
            Assert.fail("Should not allow to have stats higher than max attribute specified");
        } catch (IllegalStateException ex) {
            Assert.assertEquals("[2] is\\are used on attribute [Armor], allowed range is from 0 to 1", ex.getMessage());
        }
    }

    @Test
    public void testShouldValidateMinPoints() {
        SpawningStrategy<Knight, Dragon> spawningStrategy = createUpdateKnightStrategy(true, KNIGHT_NAME, -1, 3);
        UnitSpawningService<Knight, Dragon> testInstance = new UnitSpawningService<>(2, 0,3, Arrays.asList(spawningStrategy));
        try {
            Knight knight = testInstance.spawn(null, null);
            Assert.fail("Should not allow to have stats lower than min attribute specified");
        } catch (IllegalStateException ex) {
            Assert.assertEquals("[-1] is\\are used on attribute [Armor], allowed range is from 0 to 3", ex.getMessage());
        }
    }

    private SpawningStrategy<Knight, Dragon> createUpdateKnightStrategy(boolean isApplicable, String name, int armor, int attack) {
        SpawningStrategy<Knight, Dragon> spawningStrategy = new SpawningStrategy<Knight, Dragon>() {
            @Override
            public boolean isApplicable(WeatherCodeEnum weatherCodeEnum) {
                return isApplicable;
            }

            @Override
            public Knight spawn(Dragon enemy) {
                Knight testKnight = new Knight();
                testKnight.setAgility(new Attribute(AttributeTypeEnum.AGILITY, 0));
                testKnight.setEndurance(new Attribute(AttributeTypeEnum.ENDURANCE, 0));
                testKnight.setArmor(new Attribute(AttributeTypeEnum.ARMOR, armor));
                testKnight.setAttack(new Attribute(AttributeTypeEnum.ATTACK, attack));
                testKnight.setName(name);
                return testKnight;
            }
        };
        return spawningStrategy;
    }

}