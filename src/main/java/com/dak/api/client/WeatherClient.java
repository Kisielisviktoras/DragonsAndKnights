package com.dak.api.client;

import com.dak.api.dto.WeatherReportDTO;

import javax.ws.rs.core.MediaType;

/**
 * Client responsible for communicating with Weather API
 *
 * @author Saji
 */
public class WeatherClient extends AbstractClient {

    private static final String basePath = "weather/api";

    public WeatherReportDTO getWeather(Long gameId) {
        return getWebTarget().path(basePath).path("report").path(gameId.toString()).request(MediaType.APPLICATION_XML_TYPE).get().readEntity(WeatherReportDTO.class);
    }

}
