package ca.hccis.squash.bo;

import ca.hccis.squash.entity.PlayerTrackerDataDto;
import ca.hccis.squash.jpa.entity.PlayerTrackerData;

/**
 * Calculates player stats
 *
 * @author Thomas McNally
 * @since Oct 1, 2026
 */

public class PlayerTrackerBO {

    public static int totalPoints(PlayerTrackerData player) {
        //Calculates total points for player
        return player.getPlayerGoals() + player.getPlayerAssists();
    }

    public static double pointsPerGame(PlayerTrackerData player) {
        //Calculates points per game
        float goals = player.getPlayerGoals();
        double perGame = (goals + player.getPlayerAssists()) / player.getPlayerMatches();
        return perGame;
    }

    public static double scoringPercentage(PlayerTrackerData player) {
        //Calculates player scoring percentage
        double goals = (player.getPlayerGoals());
        if (goals > player.getPlayerShots()) {
            return 0;
        }
        return (goals / player.getPlayerShots()) * 100;
    }

}
