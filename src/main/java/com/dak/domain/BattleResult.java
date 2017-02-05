package com.dak.domain;

import com.dak.domain.constants.BattleStatusEnum;

/**
 * @author Saji
 */

public class BattleResult {

    private BattleStatusEnum battleStatus;
    private String battleMessage;

    public BattleStatusEnum getBattleStatus() {
        return battleStatus;
    }

    public void setBattleStatus(BattleStatusEnum battleStatus) {
        this.battleStatus = battleStatus;
    }

    public String getBattleMessage() {
        return battleMessage;
    }

    public void setBattleMessage(String battleMessage) {
        this.battleMessage = battleMessage;
    }

    @Override
    public String toString() {
        return "BattleResult{" +
                "battleStatus=" + battleStatus +
                ", battleMessage='" + battleMessage + '\'' +
                '}';
    }
}
