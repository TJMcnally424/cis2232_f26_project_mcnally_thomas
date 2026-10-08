package ca.hccis.files.entity;

import java.util.Scanner;

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
        Scanner scanner = new Scanner(System.in);
        System.out.print("ID: ");
        id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("First Name: ");
        playerFirstName = scanner.nextLine();
        System.out.print("Last Name: ");
        playerLastName = scanner.nextLine();
        System.out.print("Position: ");
        playerPosition = scanner.nextLine();
        System.out.print("Goals: ");
        playerGoals = scanner.nextInt();
        System.out.print("Assists: ");
        playerAssists = scanner.nextInt();
        System.out.print("Penalty Min: ");
        playerPenaltyMin = scanner.nextFloat();
        System.out.print("Matches: ");
        playerMatches = scanner.nextInt();
        System.out.print("Wins: ");
        playerWins = scanner.nextInt();
        System.out.print("Losses: ");
        playerLosses = scanner.nextInt();
        System.out.print("Shots: ");
        playerShots = scanner.nextInt();
        System.out.print("Saves: ");
        playerSaves = scanner.nextInt();
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

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", playerFirstName='" + playerFirstName + '\'' +
                ", playerLastName='" + playerLastName + '\'' +
                ", playerPosition='" + playerPosition + '\'' +
                ", playerGoals=" + playerGoals +
                ", playerAssists=" + playerAssists +
                ", playerPenaltyMin=" + playerPenaltyMin +
                ", playerMatches=" + playerMatches +
                ", playerWins=" + playerWins +
                ", playerLosses=" + playerLosses +
                ", playerShots=" + playerShots +
                ", playerSaves=" + playerSaves +
                '}';
    }
}
