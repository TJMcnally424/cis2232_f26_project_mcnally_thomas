package ca.hccis.files.BO;

import ca.hccis.files.entity.Player;

/**
 * Calculates player stats
 *
 * @author Thomas McNally
 * @since Oct 1, 2026
 */
public class PlayerBO {

    public static int totalPoints(Player player) {
        //Calculates total points for player
        return player.getPlayerGoals() + player.getPlayerAssists();
    }

    public static double pointsPerGame(Player player) {
        //Calculates points per game
        float goals = player.getPlayerGoals();
        return (goals + player.getPlayerAssists()) / player.getPlayerMatches();
    }

    public static float scoringPercentage(Player player) {
        //Calculates player scoring percentage
        float goals = (player.getPlayerGoals());
        if (goals > player.getPlayerShots()) {
            return 0;
        }
        return (goals / player.getPlayerShots()) * 100;
    }

}
