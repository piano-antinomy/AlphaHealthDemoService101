package org.alpha.health.gov;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClinicalTrialGovClientResponse {

    @JsonProperty("StudyFieldsResponse")
    public StudyFieldsResponse studyFieldsResponse;
}
