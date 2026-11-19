package ca.hccis.squash.entity;

import ca.hccis.squash.jpa.entity.PlayerTrackerData;

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
    private ArrayList<PlayerTrackerData> playerTrackerData;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ArrayList<PlayerTrackerData> getPlayerTrackerData() {
        return playerTrackerData;
    }

    public void setPlayerTrackerData(ArrayList<PlayerTrackerData> playerTrackerData) {
        this.playerTrackerData = playerTrackerData;
    }
}
