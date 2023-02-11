package org.alpha.health.gov;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Study {
    @JsonProperty("Rank")
    public Integer rank;

    @JsonProperty("NCTId")
    public List<String> nCTId;

    @JsonProperty("Condition")
    public List<String> conditions;

    @JsonProperty("BriefTitle")
    public List<String> briefTitle;

    @JsonProperty("OfficialTitle")
    public List<String> officialTitle;

    @JsonProperty("LocationCity")
    public List<String> locationCity;

    @JsonProperty("LocationState")
    public List<String> LocationState;

    @JsonProperty("LocationZip")
    public List<String> LocationZip;
}
