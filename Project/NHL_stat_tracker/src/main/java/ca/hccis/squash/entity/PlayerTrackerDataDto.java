package ca.hccis.squash.entity;

import ca.hccis.squash.jpa.entity.PlayerTrackerData;

import java.util.ArrayList;
import java.util.List;

public class PlayerTrackerDataDto {
    private List<PlayerTrackerData> assessments;

    // default and parameterized constructor


    public PlayerTrackerDataDto() {
        assessments = new ArrayList<PlayerTrackerData>();
    }

    public PlayerTrackerDataDto(List<PlayerTrackerData> assessments) {
        this.assessments = assessments;
    }

    public void addSkillsAssessmentSquashTechnical(PlayerTrackerData playerTrackerData) {
        this.assessments.add(playerTrackerData);
    }

    public List<PlayerTrackerData> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<PlayerTrackerData> assessments) {
        this.assessments = assessments;
    }
}
