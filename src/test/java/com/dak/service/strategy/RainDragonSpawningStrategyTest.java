package com.dak.service.strategy;

import com.dak.domain.Dragon;
import com.dak.domain.constants.WeatherCodeEnum;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Saji
 */
public class RainDragonSpawningStrategyTest {

    private RainDragonSpawningStrategy testInstance = new RainDragonSpawningStrategy();

    @Test
    public void testApplicableWhenDry() throws Exception {
        Assert.assertTrue(testInstance.isApplicable(WeatherCodeEnum.RAIN));
        Assert.assertFalse(testInstance.isApplicable(WeatherCodeEnum.NORMAL));
        Assert.assertFalse(testInstance.isApplicable(WeatherCodeEnum.DRY));
        Assert.assertFalse(testInstance.isApplicable(WeatherCodeEnum.STORM));
        Assert.assertFalse(testInstance.isApplicable(WeatherCodeEnum.FOG));
    }

    @Test
    public void testSpawnDragon() throws Exception {
        Dragon dragon = testInstance.spawn(null);
        Assert.assertEquals(5, dragon.getWingStrength().getValue());
        Assert.assertEquals(5, dragon.getScaleThickness().getValue());
        Assert.assertEquals(0, dragon.getFireBreath().getValue());
        Assert.assertEquals(10, dragon.getClawSharpness().getValue());
    }

}