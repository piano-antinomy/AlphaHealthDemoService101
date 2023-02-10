package org.alpha.health.demo.model.trials;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Builder
@ToString
public class ClinicalTrial {
    public TrialIdentification trialIdentification;

    public TrialStatus trialStatus;

    public TrialLocation trialLocation;

    public List<TrialLocation> allTrialLocations;

    public StudyCondition studyCondition;
}
