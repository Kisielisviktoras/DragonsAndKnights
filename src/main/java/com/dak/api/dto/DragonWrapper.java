package com.dak.api.dto;

import com.dak.domain.Dragon;

import java.io.Serializable;

/**
 * Holder from dragon to sent to game api
 * Jackson generates json and does not include class name as root element for json
 * this can be achieved by configuring client configs and so on for simplicity reason will skip this
 * @author Saji
 */
public class DragonWrapper implements Serializable {

    private DragonDTO dragon;

    public DragonWrapper(DragonDTO dragon) {
        this.dragon = dragon;
    }

    public DragonDTO getDragon() {
        return dragon;
    }

    public void setDragon(DragonDTO dragon) {
        this.dragon = dragon;
    }
}
