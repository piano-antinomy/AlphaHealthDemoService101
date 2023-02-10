package org.alpha.health.demo.model;

import lombok.Builder;
import lombok.ToString;
import org.alpha.health.demo.model.trials.ClinicalTrial;

import java.util.List;

@Builder
@ToString
public class QueryClinicalTrialsResponse {
    public List<ClinicalTrial> clinicalTrialList;
}
