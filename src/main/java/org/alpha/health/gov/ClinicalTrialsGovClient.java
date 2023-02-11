package org.alpha.health.gov;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class ClinicalTrialsGovClient {
    private static String FIELD_LIST =
        "fields=NCTId,Condition,BriefTitle,OfficialTitle,LocationCity,LocationState,LocationZip";
    private static String CLINICAL_TRIALS_GOV_URL = "https://clinicaltrials.gov/api/query/study_fields?";

    private final ObjectMapper objectMapper = new ObjectMapper();
    /**
     * gets Json response from clinical trials gov api
     * @param expression
     * @return
     */
    public String getStudiesWithSpecifiedFields(String expression) {
        try {
            String constructedURL = CLINICAL_TRIALS_GOV_URL
                + "expr="
                + expression
                + "&"
                + FIELD_LIST
                + "&fmt=JSON";

            final URL url = new URL(constructedURL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            final int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode from https://clinicaltrials.gov/: " + responseCode);
            }

            String response = new BufferedReader(
                new InputStreamReader(url.openStream(), StandardCharsets.UTF_8))
                .lines()
                .collect(Collectors.joining("\n"));


            final ClinicalTrialGovClientResponse clinicalTrialGovClientResponse =
                objectMapper.readValue(response, ClinicalTrialGovClientResponse.class);

            return clinicalTrialGovClientResponse.toString();

        } catch (final Exception e) {
            throw new RuntimeException("SERVER Error: " + e);
        }


    }
}
