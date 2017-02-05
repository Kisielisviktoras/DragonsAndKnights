package com.dak.domain;

import java.io.Serializable;

/**
 * Class representing game object
 *
 * @author Saji
 */
public class Game implements Serializable {

    private Long gameId;
    private Knight knight;

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

    @Override
    public String toString() {
        return "Game{" +
                "gameId=" + gameId +
                ", knight=" + knight +
                '}';
    }
}
