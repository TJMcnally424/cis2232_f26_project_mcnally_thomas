package ca.hccis.files;

import ca.hccis.files.entity.Player;
import ca.hccis.util.CisUtility;
import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

/**
 * Controls the overall flow of the program.
 *
 * @author Thomas McNally
 * @since 9/24/2026
 */
public class Controller {

    public static Gson gson = new Gson();

    public static final String MENU = "A) add" + System.lineSeparator()
            + "V) view" + System.lineSeparator()
            + "X) eXit"
            + System.lineSeparator();

    public static final String MESSAGE_ERROR = "Error";
    public static final String MESSAGE_EXIT = "Goodbye";

    public static void main(String[] args) {

        initialize();

        String menuOption;

        do {
            menuOption = CisUtility.getInputString(MENU).toUpperCase();

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
    public static void processMenuOption1() {
        System.out.println("Add new player: ");
        write();
    }

    /**
     * Processing for menu option 2.
     *
     * @author Thomas McNally
     * @since 9/24/2026
     */
    public static void processMenuOption2() {
        System.out.println("Viewing current players: ");
        read();
    }

    public static void write() {
        try {
            FileWriter writer = new FileWriter("c:/cis2232/data_mcnally_thomas.json", true);
            Player player = new Player();
            player.getInformation();
            writer.append(gson.toJson(player));
            writer.append(System.lineSeparator());
            System.out.println("Successfully written JSON string to file.");
            writer.close();
        } catch (IOException e) {}
    }

    public static void read() {
        try {
            FileReader reader = new FileReader("c:/cis2232/data_mcnally_thomas.json");
            List<String> lines = reader.readAllLines();
            for(int i = 0; i < lines.size(); i++) {
                Player playerFromJson = gson.fromJson(lines.get(i), Player.class);
                IO.println(playerFromJson);
            }
        } catch (IOException e) {}
    }

    public static void initialize() {
        //creates directory and file if needed
        Path directory = Paths.get("c:/cis2232/");
        Path path = Paths.get("c:/cis2232/data_mcnally_thomas.json");
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(directory);
                Files.createFile(path);
            } catch (IOException e) {}
        }
    }
}
