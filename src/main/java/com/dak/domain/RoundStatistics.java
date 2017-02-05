package com.dak.domain;

import com.dak.domain.constants.BattleStatusEnum;
import com.dak.domain.constants.WeatherCodeEnum;

/**
 * @author Saji
 */
public class RoundStatistics {

    private BattleStatusEnum battleResult;
    private WeatherCodeEnum weatherCode;
    private Long gameId;
    private Knight knight;
    private Dragon dragon;

    public RoundStatistics() {
    }

    public RoundStatistics(BattleStatusEnum battleResult, WeatherCodeEnum weatherCode, Long gameId, Knight knight, Dragon dragon) {
        this.battleResult = battleResult;
        this.weatherCode = weatherCode;
        this.gameId = gameId;
        this.knight = knight;
        this.dragon = dragon;
    }

    public BattleStatusEnum getBattleResult() {
        return battleResult;
    }

    public void setBattleResult(BattleStatusEnum battleResult) {
        this.battleResult = battleResult;
    }

    public WeatherCodeEnum getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(WeatherCodeEnum weatherCode) {
        this.weatherCode = weatherCode;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Knight getKnight() {
        return knight;
    }

    public void setKnight(Knight knight) {
        this.knight = knight;
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

}
