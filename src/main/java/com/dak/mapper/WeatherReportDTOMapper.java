package com.dak.mapper;

import com.dak.api.dto.WeatherReportDTO;
import com.dak.domain.WeatherReport;
import com.dak.domain.constants.WeatherCodeEnum;

/**
 * @author Saji
 */
public class WeatherReportDTOMapper {

    private CoordinatesDTOMapper coordinatesDTOMapper = new CoordinatesDTOMapper();

    public WeatherReport mapToDto(WeatherReportDTO weatherReportDTO) {
        WeatherReport weatherReport = new WeatherReport();
        weatherReport.setBattleDate(weatherReportDTO.getTime());
        weatherReport.setWeatherCode(WeatherCodeEnum.of(weatherReportDTO.getCode()));
        weatherReport.setMessage(weatherReportDTO.getMessage());
        weatherReport.setCoords(coordinatesDTOMapper.mapFromDTO(weatherReportDTO.getCoords()));
        weatherReport.setRating(weatherReportDTO.getRating());
        return weatherReport;
    }
}
