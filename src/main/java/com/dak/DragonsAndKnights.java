package com.dak;

import com.dak.api.client.GameClient;
import com.dak.api.client.WeatherClient;
import com.dak.api.dto.BattleResultDTO;
import com.dak.api.dto.DragonDTO;
import com.dak.api.dto.GameDTO;
import com.dak.api.dto.WeatherReportDTO;
import com.dak.domain.*;
import com.dak.domain.constants.BattleStatusEnum;
import com.dak.mapper.BattleResultDTOMapper;
import com.dak.mapper.DragonDTOMapper;
import com.dak.mapper.KnightDTOMapper;
import com.dak.mapper.WeatherReportDTOMapper;
import com.dak.service.SpawningService;
import com.dak.service.UnitSpawningService;
import com.dak.service.strategy.DryDragonSpawningStrategy;
import com.dak.service.strategy.NormalDragonSpawningStrategy;
import com.dak.service.strategy.RainDragonSpawningStrategy;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Saji
 */
public class DragonsAndKnights {
    private static GameClient gameClient = new GameClient();
    private static WeatherClient weatherClient = new WeatherClient();
    private static KnightDTOMapper knightDTOMapper = new KnightDTOMapper();
    private static WeatherReportDTOMapper weatherReportDTOMapper = new WeatherReportDTOMapper();
    private static DragonDTOMapper dragonDTOMapper = new DragonDTOMapper();
    private static BattleResultDTOMapper battleResultDTOMapper = new BattleResultDTOMapper();
    private static SpawningService<Dragon, Knight> dragonSpawningService = new UnitSpawningService(20, 0, 10,
            Arrays.asList(new NormalDragonSpawningStrategy(), new RainDragonSpawningStrategy(), new DryDragonSpawningStrategy()));

    public static void main(String... args) {
        int totalRounds = args.length > 0 ? Math.abs(Integer.valueOf(args[0])) : 100;
        List<RoundStatistics> statistics = new ArrayList<>();

        for (int i = 0; i < totalRounds; i++) {
            System.out.print(String.format("Battle %s in progress", i));
            GameDTO game = gameClient.startBattle();
            WeatherReportDTO weatherReportDTO = weatherClient.getWeather(game.getGameId());
            WeatherReport weatherReport = weatherReportDTOMapper.mapToDto(weatherReportDTO);

            Knight knight = knightDTOMapper.mapFromDTO(game.getKnight());
            Dragon dragon = dragonSpawningService.spawn(knight, weatherReport.getWeatherCode());

            DragonDTO dragonDTO = dragonDTOMapper.mapToDTO(dragon);
            BattleResultDTO battleResultDTO = gameClient.battle(game.getGameId(), dragonDTO);

            BattleResult battleResult = battleResultDTOMapper.mapToBattleResult(battleResultDTO);
            System.out.println(String.format(" battles has ended in - %s", battleResult.getBattleStatus()));

            statistics.add(new RoundStatistics(battleResult.getBattleStatus(), weatherReport.getWeatherCode(), game.getGameId(), knight, dragon));
        }

        logStatistics(statistics);

    }

    private static void logStatistics(List<RoundStatistics> totalFoughtBattles) {
        if (totalFoughtBattles.isEmpty()) {
            return;
        }

        Map<BattleStatusEnum, List<RoundStatistics>> battlesByResult = totalFoughtBattles.stream()
                .collect(Collectors.groupingBy(RoundStatistics::getBattleResult));
        System.out.println("");
        System.out.println(String.format("Fought total of %s battles", totalFoughtBattles.size()));
        Integer wonBattles = battlesByResult.get(BattleStatusEnum.VICTORY).size();
        System.out.println(String.format("Won %s battles", wonBattles));
        System.out.println(String.format("Lost %s battles", battlesByResult.get(BattleStatusEnum.DEFEAT)));
        BigDecimal winRate = new BigDecimal(100).multiply(new BigDecimal(wonBattles))
                .divide(new BigDecimal(totalFoughtBattles.size())).setScale(2);
        System.out.println(String.format("Win rate is %s percent", winRate));
        System.out.println("");
        System.out.println("Lost games statistics");
        for (RoundStatistics lostBattle : battlesByResult.get(BattleStatusEnum.DEFEAT)) {
            System.out.println(String.format("GameId: %s in weather %s", lostBattle.getGameId(), lostBattle.getWeatherCode()));
            System.out.println(String.format("Opponent: %s", lostBattle.getKnight()));
            System.out.println(String.format("Unit sent: %s", lostBattle.getDragon()));
        }


    }

}
