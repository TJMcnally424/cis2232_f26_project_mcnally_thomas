package ca.hccis.files;

import ca.hccis.files.threads.ThreadPlayerTracker;
import ca.hccis.files.util.CisUtility;


/**
 * Controls the overall flow of the program.
 *
 * @author Thomas McNally
 * @since 9/24/2026
 */
public class Controller {
    public static void main(String[] args) {

        Thread threadConsole = new ThreadPlayerTracker(new CisUtility(false));
        Thread threadGUI = new ThreadPlayerTracker(new CisUtility(true));

        threadConsole.start();
        threadGUI.start();

    }
}
