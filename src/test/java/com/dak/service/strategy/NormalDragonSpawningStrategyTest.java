package com.dak.service.strategy;

import com.dak.domain.Attribute;
import com.dak.domain.Dragon;
import com.dak.domain.Knight;
import com.dak.domain.constants.AttributeTypeEnum;
import com.dak.domain.constants.WeatherCodeEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Saji
 */
public class NormalDragonSpawningStrategyTest {

    private NormalDragonSpawningStrategy testInstance = new NormalDragonSpawningStrategy();

    @Test
    public void testApplicableWhenDry() throws Exception {
        Assert.assertTrue(testInstance.isApplicable(WeatherCodeEnum.NORMAL));
        Assert.assertTrue(testInstance.isApplicable(WeatherCodeEnum.FOG));
        Assert.assertTrue(testInstance.isApplicable(WeatherCodeEnum.STORM));
        Assert.assertFalse(testInstance.isApplicable(WeatherCodeEnum.DRY));
        Assert.assertFalse(testInstance.isApplicable(WeatherCodeEnum.RAIN));
    }

    @Test
    public void testSpawnDragon() throws Exception {
        Knight knight = createKnight(3, 3, 8, 6);
        Dragon dragon = testInstance.spawn(knight);
        assertDragon(dragon, 3, 2, 5, 10);

        knight = createKnight(6, 6, 4, 4);
        dragon = testInstance.spawn(knight);
        assertDragon(dragon, 9, 5, 3, 3);

        knight = createKnight(5, 5, 5, 5);
        dragon = testInstance.spawn(knight);
        assertDragon(dragon, 8, 4, 4, 4);

        knight = createKnight(2, 2, 8, 8);
        dragon = testInstance.spawn(knight);
        assertDragon(dragon, 2, 1, 10, 7);
    }


    private void assertDragon(Dragon dragon, int clawSharpness, int scaleThickness, int fireBreath, int wingStrength) {
        Assert.assertEquals(wingStrength, dragon.getWingStrength().getValue());
        Assert.assertEquals(scaleThickness, dragon.getScaleThickness().getValue());
        Assert.assertEquals(fireBreath, dragon.getFireBreath().getValue());
        Assert.assertEquals(clawSharpness, dragon.getClawSharpness().getValue());
    }

    private Knight createKnight(int attack, int armor, int agility, int endurance) {
        Knight knight = new Knight();
        knight.setArmor(new Attribute(AttributeTypeEnum.ARMOR, armor));
        knight.setAttack(new Attribute(AttributeTypeEnum.ATTACK, attack));
        knight.setAgility(new Attribute(AttributeTypeEnum.AGILITY, agility));
        knight.setEndurance(new Attribute(AttributeTypeEnum.ENDURANCE, endurance));
        return knight;
    }
}