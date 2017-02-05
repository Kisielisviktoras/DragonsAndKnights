package com.dak.domain;

import com.dak.domain.constants.WeatherCodeEnum;

import java.util.Date;

/**
 * @author Saji
 */

public class WeatherReport {
    private Date battleDate;
    private Coordinates coords;
    private WeatherCodeEnum weatherCode;
    private String message;
    private String rating;

    public Date getBattleDate() {
        return battleDate;
    }

    public void setBattleDate(Date battleDate) {
        this.battleDate = battleDate;
    }

    public Coordinates getCoords() {
        return coords;
    }

    public void setCoords(Coordinates coords) {
        this.coords = coords;
    }

    public WeatherCodeEnum getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(WeatherCodeEnum weatherCode) {
        this.weatherCode = weatherCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "WeatherReport{" +
                "battleDate=" + battleDate +
                ", coords=" + coords +
                ", weatherCode=" + weatherCode +
                ", message='" + message + '\'' +
                ", rating='" + rating + '\'' +
                '}';
    }
}
