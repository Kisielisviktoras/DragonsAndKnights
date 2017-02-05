package com.dak.mapper;

import com.dak.api.dto.KnightDTO;
import com.dak.domain.Attribute;
import com.dak.domain.Knight;
import com.dak.domain.constants.AttributeTypeEnum;

/**
 * @author Saji
 */
public class KnightDTOMapper {

    public Knight mapFromDTO(KnightDTO dto) {
        Knight knight = new Knight();
        knight.setAgility(new Attribute(AttributeTypeEnum.AGILITY, dto.getAgility()));
        knight.setArmor(new Attribute(AttributeTypeEnum.ARMOR, dto.getArmor()));
        knight.setAttack(new Attribute(AttributeTypeEnum.ATTACK, dto.getAttack()));
        knight.setEndurance(new Attribute(AttributeTypeEnum.ENDURANCE, dto.getEndurance()));
        knight.setName(dto.getName());
        return knight;
    }

}
