package com.dak.api.dto;

import java.io.Serializable;

/**
 * @author Saji
 */
public class GameDTO implements Serializable {
    private Long gameId;
    private KnightDTO knight;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public KnightDTO getKnight() {
        return knight;
    }

    public void setKnight(KnightDTO knight) {
        this.knight = knight;
    }

    @Override
    public String toString() {
        return "GameDTO{" +
                "gameId=" + gameId +
                ", knight=" + knight +
                '}';
    }
}
