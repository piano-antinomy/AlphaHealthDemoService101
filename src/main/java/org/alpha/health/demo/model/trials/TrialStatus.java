package org.alpha.health.demo.model.trials;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.Date;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrialStatus {
    public String overallStatus;

    public Date statusVerifiedDate;

    public Date startDate;

}
