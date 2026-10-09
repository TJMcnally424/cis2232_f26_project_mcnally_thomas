package ca.hccis.files.entity;

import ca.hccis.files.util.CisUtility;
import ca.hccis.files.BO.PlayerBO;

public class Player {

    private int id;
    private String playerFirstName;
    private String playerLastName;
    private String playerPosition;
    private int playerGoals;
    private int playerAssists;
    private float playerPenaltyMin;
    private int playerMatches;
    private int playerWins;
    private int playerLosses;
    private int playerShots;
    private int playerSaves;
    private transient CisUtility cisUtility = new CisUtility();
    public Player(CisUtility cisUtility) {
        this.cisUtility = cisUtility;
    }


    public int getPlayerGoals() {
        return playerGoals;
    }

    public void setPlayerGoals(int playerGoals) {
        this.playerGoals = playerGoals;
    }

    public Player() {
    }

    public Player(int id,  String firstName, String lastName, String playerPosition, int playerGoals
    , int playerAssists,  float playerPenaltyMin, int playerMatches,  int playerWins, int playerLosses, int playerShots, int playerSaves) {
        this.id = id;
        this.playerFirstName = firstName;
        this.playerLastName = lastName;
        this.playerPosition = playerPosition;
        this.playerGoals = playerGoals;
        this.playerAssists = playerAssists;
        this.playerPenaltyMin = playerPenaltyMin;
        this.playerMatches = playerMatches;
        this.playerWins = playerWins;
        this.playerLosses = playerLosses;
        this.playerShots = playerShots;
        this.playerSaves = playerSaves;
    }

    public void getInformation() {
        id = cisUtility.getInputInt("ID: ");
        playerFirstName = cisUtility.getInputString("First Name: ");
        playerLastName = cisUtility.getInputString("Last Name: ");
        playerPosition = cisUtility.getInputString("Position: ");
        playerGoals = cisUtility.getInputInt("Goals: ");
        playerAssists = cisUtility.getInputInt("Assists: ");
        playerPenaltyMin = cisUtility.getInputFloat("Penalty Minutes");
        playerMatches = cisUtility.getInputInt("Matches: ");
        playerWins = cisUtility.getInputInt("Wins: ");
        playerLosses = cisUtility.getInputInt("Losses: ");
        playerShots = cisUtility.getInputInt("Shots: ");
        playerSaves = cisUtility.getInputInt("Saves: ");
    }
    public void setPlayerAssists(int playerAssists) {
        this.playerAssists = playerAssists;
    }

    public void setPlayerPenaltyMin(float playerPenaltyMin) {
        this.playerPenaltyMin = playerPenaltyMin;
    }

    public void setPlayerMatches(int playerMatches) {
        this.playerMatches = playerMatches;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    public void setPlayerLosses(int playerLosses) {
        this.playerLosses = playerLosses;
    }

    public void setPlayerShots(int playerShots) {
        this.playerShots = playerShots;
    }

    public void setPlayerSaves(int playerSaves) {
        this.playerSaves = playerSaves;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getPlayerAssists() {
        return playerAssists;
    }

    public float getPlayerPenaltyMin() {
        return playerPenaltyMin;
    }

    public int getPlayerMatches() {
        return playerMatches;
    }

    public int getPlayerWins() {
        return playerWins;
    }

    public int getPlayerLosses() {
        return playerLosses;
    }

    public int getPlayerShots() {
        return playerShots;
    }

    public int getPlayerSaves() {
        return playerSaves;
    }

    @Override
    public String toString() {
        return "Player: " +
                "id=" + id +
                ", player FirstName='" + playerFirstName + '\'' +
                ", player LastName='" + playerLastName + '\'' +
                ", player Position='" + playerPosition + '\'' +
                ", player Goals=" + playerGoals +
                ", player Assists=" + playerAssists +
                ", player PenaltyMin=" + playerPenaltyMin +
                ", player Matches=" + playerMatches +
                ", player Wins=" + playerWins +
                ", player Losses=" + playerLosses +
                ", player Shots=" + playerShots +
                ", player Saves=" + playerSaves;
    }
}
