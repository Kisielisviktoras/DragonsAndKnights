package com.dak.mapper;

import com.dak.api.dto.DragonDTO;
import com.dak.domain.Dragon;

/**
 * @author Saji
 */
public class DragonDTOMapper {

    public DragonDTO mapToDTO(Dragon dragon) {
        DragonDTO dragonDTO = new DragonDTO();
        dragonDTO.setClawSharpness(dragon.getClawSharpness().getValue());
        dragonDTO.setFireBreath(dragon.getFireBreath().getValue());
        dragonDTO.setScaleThickness(dragon.getScaleThickness().getValue());
        dragonDTO.setWingStrength(dragon.getWingStrength().getValue());
        return dragonDTO;

    }

}
