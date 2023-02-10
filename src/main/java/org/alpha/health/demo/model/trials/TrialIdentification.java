package org.alpha.health.demo.model.trials;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class TrialIdentification {
    public String nctId;

    public String briefTitle;

    public String OfficialTitle;
}
