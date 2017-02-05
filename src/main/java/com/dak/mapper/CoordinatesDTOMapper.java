package com.dak.mapper;

import com.dak.api.dto.CoordinatesDTO;
import com.dak.domain.Coordinates;

/**
 * @author Saji
 */
public class CoordinatesDTOMapper {

    public Coordinates mapFromDTO(CoordinatesDTO dto) {
        Coordinates coordinates = new Coordinates();
        coordinates.setX(dto.getX());
        coordinates.setY(dto.getY());
        coordinates.setZ(dto.getZ());
        return coordinates;
    }
}
