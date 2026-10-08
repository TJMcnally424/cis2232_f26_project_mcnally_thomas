package ca.hccis.files.BO;

import ca.hccis.files.entity.Player;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerBOTest {
    /**
     * Test 1 created by Thomas following TDD
     *
     * @author TJM
     * @since 20261001
     */
    @Test
    void testDetermineTotalScore25Goal25Assist() {

        Player player = new Player();
        player.setPlayerGoals(25);
        player.setPlayerAssists(25);

        int actual = PlayerBO.totalPoints(player);

        assertEquals(50, actual);
    }

    /**
     * Test 2 created by Thomas following TDD
     *
     * @author TJM
     * @since 20261001
     */
    @Test
    void testDeterminePointsPerGame100_8() {

        Player player = new Player();
        player.setPlayerGoals(50);
        player.setPlayerAssists(50);
        player.setPlayerMatches(8);

        double actual = PlayerBO.pointsPerGame(player);

        assertEquals(12.5, actual);
    }

    /**
     * Test 3 created by Thomas following TDD
     *
     * @author TJM
     * @since 20261001
     */
    @Test
    void testDetermineScoringPercentage1_2() {

        Player player = new Player();
        player.setPlayerGoals(1);
        player.setPlayerShots(2);

        double actual = PlayerBO.scoringPercentage(player);

        assertEquals(50, actual);
    }

    @Test
    void testDetermineScoringPercentage4_2() {
        //Player can't have more goals than shots
        Player player = new Player();
        player.setPlayerGoals(4);
        player.setPlayerShots(2);

        double actual = PlayerBO.scoringPercentage(player);

        assertNotEquals(200, actual);
    }

    //****************************************************************************
    //The code was created by Claude Code AI
    //****************************************************************************
    /**
     * Tests for PlayerBO
     * <p>
     * Assumes Player has setters: setPlayerGoals, setPlayerAssists,
     * setPlayerMatches and setPlayerShots (all int). Adjust if yours differ.
     *
     * @since Oct 1, 2026
     */
    private Player playerAI;

    @BeforeEach
    public void setUp() {
        playerAI = new Player();
    }

    private void setStats(int goals, int assists, int matches, int shots) {
        playerAI.setPlayerGoals(goals);
        playerAI.setPlayerAssists(assists);
        playerAI.setPlayerMatches(matches);
        playerAI.setPlayerShots(shots);
    }

    // ---------- totalPoints ----------

    @Test
    public void totalPoints_goalsAndAssists_returnsSum() {
        setStats(10, 5, 20, 40);
        assertEquals(15, PlayerBO.totalPoints(playerAI));
    }

    @Test
    public void totalPoints_allZero_returnsZero() {
        setStats(0, 0, 0, 0);
        assertEquals(0, PlayerBO.totalPoints(playerAI));
    }

    @Test
    public void totalPoints_onlyGoals_returnsGoals() {
        setStats(7, 0, 10, 20);
        assertEquals(7, PlayerBO.totalPoints(playerAI));
    }

    @Test
    public void totalPoints_onlyAssists_returnsAssists() {
        setStats(0, 9, 10, 20);
        assertEquals(9, PlayerBO.totalPoints(playerAI));
    }

    // ---------- pointsPerGame ----------

    @Test
    public void pointsPerGame_typicalValues_returnsAverage() {
        setStats(10, 5, 10, 40);
        assertEquals(1.5, PlayerBO.pointsPerGame(playerAI), 0.0001);
    }

    @Test
    public void pointsPerGame_nonIntegerResult_usesDecimalDivision() {
        // 3 points over 2 games = 1.5, not 1 (guards against integer division)
        setStats(2, 1, 2, 10);
        assertEquals(1.5, PlayerBO.pointsPerGame(playerAI), 0.0001);
    }

    @Test
    public void pointsPerGame_noPoints_returnsZero() {
        setStats(0, 0, 10, 10);
        assertEquals(0.0, PlayerBO.pointsPerGame(playerAI), 0.0001);
    }

    @Test
    public void pointsPerGame_zeroMatchesWithPoints_returnsInfinity() {
        // Current behaviour: float division by zero -> Infinity (no exception)
        setStats(5, 3, 0, 10);
        assertTrue(Double.isInfinite(PlayerBO.pointsPerGame(playerAI)));
    }

    @Test
    public void pointsPerGame_zeroMatchesNoPoints_returnsNaN() {
        // Current behaviour: 0.0 / 0 -> NaN
        setStats(0, 0, 0, 0);
        assertTrue(Double.isNaN(PlayerBO.pointsPerGame(playerAI)));
    }

    // ---------- scoringPercentage ----------

    @Test
    public void scoringPercentage_typicalValues_returnsPercentage() {
        setStats(10, 0, 20, 40);
        assertEquals(25.0f, PlayerBO.scoringPercentage(playerAI), 0.0001f);
    }

    @Test
    public void scoringPercentage_goalsEqualShots_returns100() {
        setStats(10, 0, 20, 10);
        assertEquals(100.0f, PlayerBO.scoringPercentage(playerAI), 0.0001f);
    }

    @Test
    public void scoringPercentage_goalsExceedShots_returnsZero() {
        // Invalid data guard in the method
        setStats(11, 0, 20, 10);
        assertEquals(0.0f, PlayerBO.scoringPercentage(playerAI), 0.0001f);
    }

    @Test
    public void scoringPercentage_noGoalsWithShots_returnsZero() {
        setStats(0, 2, 20, 15);
        assertEquals(0.0f, PlayerBO.scoringPercentage(playerAI), 0.0001f);
    }

    @Test
    public void scoringPercentage_nonIntegerResult_usesDecimalDivision() {
        // 1 goal / 3 shots = 33.333...%
        setStats(1, 0, 5, 3);
        assertEquals(33.3333f, PlayerBO.scoringPercentage(playerAI), 0.001f);
    }

    @Test
    public void scoringPercentage_zeroShotsZeroGoals_returnsNaN() {
        // Current behaviour: 0.0 / 0 -> NaN (the goals > shots guard doesn't catch it)
        setStats(0, 0, 5, 0);
        assertTrue(Float.isNaN(PlayerBO.scoringPercentage(playerAI)));
    }


}


