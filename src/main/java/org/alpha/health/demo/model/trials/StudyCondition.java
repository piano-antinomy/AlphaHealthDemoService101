package org.alpha.health.demo.model.trials;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.util.List;

@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudyCondition {
    public List<String> conditions;
}
