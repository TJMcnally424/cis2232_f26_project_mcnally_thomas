package ca.hccis.files.threads;


import ca.hccis.files.entity.Player;
import ca.hccis.files.util.CisUtility;
import com.google.gson.Gson;
import ca.hccis.files.BO.PlayerBO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.List;

public class ThreadPlayerTracker extends Thread {

    public static Gson gson = new Gson();

    public static final String MENU = "A) add" + System.lineSeparator()
            + "V) view" + System.lineSeparator()
            + "X) eXit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";

    private CisUtility cisUtility = null;

    public ThreadPlayerTracker() {
    }

    public ThreadPlayerTracker(CisUtility cisUtility) {
        this.cisUtility = cisUtility;
    }

    public void setCisUtility(CisUtility cisUtility) {
        this.cisUtility = cisUtility;
    }


    public void run() {

        initialize();

        String menuOption;

        do {
            menuOption = cisUtility.getInputString(MENU);

            switch (menuOption) {
                case "X":
                    System.out.println(MESSAGE_EXIT);
                    break; //Break out of the loop as we're finished.
                case "A":
                    processMenuOption1();
                    break;
                case "V":
                    processMenuOption2();
                    break;
                default:
                    System.out.println(MESSAGE_ERROR);
                    break;
            }
        } while (!menuOption.equals("X"));
    }

    /**
     * Processing for menu option 1
     *
     * @author Thomas McNally
     * @since 9/24/2026
     */
    public void processMenuOption1() {
        write();
    }

    /**
     * Processing for menu option 2.
     *
     * @author Thomas McNally
     * @since 9/24/2026
     */
    public void processMenuOption2() {
        read();
    }

    public void write() {
        Player player = new Player(cisUtility);
        try {
            FileWriter writer = new FileWriter("c:/cis2232/data_mcnally_thomas.json", true);
            player.getInformation();
            writer.append(gson.toJson(player));
            writer.append(System.lineSeparator());
            System.out.println("Successfully written JSON string to file.");
            writer.close();
        } catch (IOException e) {
        }
    }

    public void read() {
        Gson gson = new Gson();

        try {
            FileReader reader = new FileReader("c:/cis2232/data_mcnally_thomas.json");
            List<String> lines = reader.readAllLines();
            String output = "";
            for (String current : lines) {
                Player player = gson.fromJson(current, Player.class);
                output += player.toString() + System.lineSeparator()
                + "Player Stats:  Scoring percentage = " + PlayerBO.scoringPercentage(player)
                        + ", Points per game = " + PlayerBO.pointsPerGame(player) +
                        ", Total Points = " + PlayerBO.totalPoints(player) + System.lineSeparator()
                        + System.lineSeparator();

            }

            cisUtility.display(output);
        } catch (IOException e) {
        }
    }

    public static void initialize() {
        //creates directory and file if needed
        Path directory = Paths.get("c:/cis2232/");
        Path path = Paths.get("c:/cis2232/data_mcnally_thomas.json");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(directory);
                Files.createFile(path);
            } catch (IOException e) {
            }
        }
    }

}
