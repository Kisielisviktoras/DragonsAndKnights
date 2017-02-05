package com.dak.api.dto;

import java.io.Serializable;

/**
 * @author Saji
 */
public class BattleResultDTO implements Serializable {
    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BattleResultDTO{" +
                "status='" + status + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
