package ca.hccis.squash.entity;

import ca.hccis.squash.jpa.entity.Playertrackerdata;

import java.util.ArrayList;

/**
 * Entity class to hold the attributes of the reports.
 * @author Thomas McNally
 * @since 20251029
 */
public class ReportNHL {
    private String lastName;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    private String position;
    private ArrayList<Playertrackerdata> playerTrackerData;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<Playertrackerdata> getPlayerTrackerData() {
        return playerTrackerData;
    }

    public void setPlayerTrackerData(ArrayList<Playertrackerdata> playerTrackerData) {
        this.playerTrackerData = playerTrackerData;
    }
}
