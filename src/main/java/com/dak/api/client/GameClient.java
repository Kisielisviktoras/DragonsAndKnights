package com.dak.api.client;

import com.dak.api.dto.BattleResultDTO;
import com.dak.api.dto.DragonDTO;
import com.dak.api.dto.DragonWrapper;
import com.dak.api.dto.GameDTO;

import javax.ws.rs.client.Entity;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

/**
 * 0 * Game endpoint client
 *
 * @author Saji
 */
public class GameClient extends AbstractClient {

    private static final String baseApiPath = "api/game";

    public GameDTO startBattle() {
        return getWebTarget().path(baseApiPath).request(APPLICATION_JSON).get().readEntity(GameDTO.class);
    }

    public BattleResultDTO battle(Long gameId, DragonDTO dragon) {
        return getWebTarget().path(baseApiPath).path(gameId.toString()).path("/solution")
                .request().put(Entity.entity(new DragonWrapper(dragon), APPLICATION_JSON))
                .readEntity(BattleResultDTO.class);
    }


}
