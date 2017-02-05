package com.dak.mapper;

import com.dak.api.dto.BattleResultDTO;
import com.dak.domain.BattleResult;
import com.dak.domain.constants.BattleStatusEnum;

/**
 * @author Saji
 */
public class BattleResultDTOMapper {

    public BattleResult mapToBattleResult(BattleResultDTO dto) {
        BattleResult battleResult = new BattleResult();
        battleResult.setBattleMessage(dto.getMessage());
        battleResult.setBattleStatus(BattleStatusEnum.of(dto.getStatus()));
        return battleResult;
    }
}
