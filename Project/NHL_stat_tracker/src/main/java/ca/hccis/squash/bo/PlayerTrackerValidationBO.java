package ca.hccis.squash.bo;

import ca.hccis.squash.jpa.entity.PlayerTrackerData;
import ca.hccis.squash.jpa.entity.SkillsAssessmentSquashTechnical;
import java.time.LocalDate;
import java.util.ArrayList;

public class PlayerTrackerValidationBO {

    public static ArrayList<String> validateInput(PlayerTrackerData playerTrackerData) {
        ArrayList<String> errors = new ArrayList<>();

        if (playerTrackerData.getPlayerFirstName() == null || playerTrackerData.getPlayerLastName() == null) {
            errors.add("Player First Name or Player Last Name is missing");
        }
        if (playerTrackerData.getPlayerShots() < playerTrackerData.getPlayerGoals()) {
            errors.add("Player Shots must be greater than or equal to Player Goals");
        }
        return errors;
    }

}
