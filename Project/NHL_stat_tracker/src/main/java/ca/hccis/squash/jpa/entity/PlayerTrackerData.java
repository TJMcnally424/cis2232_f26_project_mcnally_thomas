package ca.hccis.squash.jpa.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "playertrackerdata", schema = "cis2232_nhl_tracker")
public class Playertrackerdata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 50)
    @NotNull
    @Column(name = "playerFirstName", nullable = false, length = 50)
    private String playerFirstName;

    @Size(max = 50)
    @NotNull
    @Column(name = "playerLastName", nullable = false, length = 50)
    private String playerLastName;

    @Size(max = 50)
    @NotNull
    @Column(name = "playerPosition", nullable = false, length = 50)
    private String playerPosition;

    @Column(name = "playerGoals")
    private Integer playerGoals;

    @Column(name = "playerAssists")
    private Integer playerAssists;

    @Column(name = "playerPenaltyMin")
    private Float playerPenaltyMin;

    @Column(name = "playerMatches")
    private Integer playerMatches;

    @Column(name = "playerWins")
    private Integer playerWins;

    @Column(name = "playerLosses")
    private Integer playerLosses;

    @Column(name = "playerShots")
    private Integer playerShots;

    @Column(name = "playerSaves")
    private Integer playerSaves;

    @Column(name = "playerPoints")
    private Integer playerPoints;

    @Column(name = "playerPointsPerGame")
    private Integer playerPointsPerGame;

    @Column(name = "playerScoringPercentage")
    private Integer playerScoringPercentage;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlayerFirstName() {
        return playerFirstName;
    }

    public void setPlayerFirstName(String playerFirstName) {
        this.playerFirstName = playerFirstName;
    }

    public String getPlayerLastName() {
        return playerLastName;
    }

    public void setPlayerLastName(String playerLastName) {
        this.playerLastName = playerLastName;
    }

    public String getPlayerPosition() {
        return playerPosition;
    }

    public void setPlayerPosition(String playerPosition) {
        this.playerPosition = playerPosition;
    }

    public Integer getPlayerGoals() {
        return playerGoals;
    }

    public void setPlayerGoals(Integer playerGoals) {
        this.playerGoals = playerGoals;
    }

    public Integer getPlayerAssists() {
        return playerAssists;
    }

    public void setPlayerAssists(Integer playerAssists) {
        this.playerAssists = playerAssists;
    }

    public Float getPlayerPenaltyMin() {
        return playerPenaltyMin;
    }

    public void setPlayerPenaltyMin(Float playerPenaltyMin) {
        this.playerPenaltyMin = playerPenaltyMin;
    }

    public Integer getPlayerMatches() {
        return playerMatches;
    }

    public void setPlayerMatches(Integer playerMatches) {
        this.playerMatches = playerMatches;
    }

    public Integer getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(Integer playerWins) {
        this.playerWins = playerWins;
    }

    public Integer getPlayerLosses() {
        return playerLosses;
    }

    public void setPlayerLosses(Integer playerLosses) {
        this.playerLosses = playerLosses;
    }

    public Integer getPlayerShots() {
        return playerShots;
    }

    public void setPlayerShots(Integer playerShots) {
        this.playerShots = playerShots;
    }

    public Integer getPlayerSaves() {
        return playerSaves;
    }

    public void setPlayerSaves(Integer playerSaves) {
        this.playerSaves = playerSaves;
    }

    public Integer getPlayerPoints() {
        return playerPoints;
    }

    public void setPlayerPoints(Integer playerPoints) {
        this.playerPoints = playerPoints;
    }

    public Integer getPlayerPointsPerGame() {
        return playerPointsPerGame;
    }

    public void setPlayerPointsPerGame(Integer playerPointsPerGame) {
        this.playerPointsPerGame = playerPointsPerGame;
    }

    public Integer getPlayerScoringPercentage() {
        return playerScoringPercentage;
    }

    public void setPlayerScoringPercentage(Integer playerScoringPercentage) {
        this.playerScoringPercentage = playerScoringPercentage;
    }

}