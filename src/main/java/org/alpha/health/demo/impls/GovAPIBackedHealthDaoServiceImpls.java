package org.alpha.health.demo.impls;

import org.alpha.health.demo.api.HealthDaoService;
import org.alpha.health.demo.model.QueryClinicalTrialsRequest;
import org.alpha.health.demo.model.QueryClinicalTrialsResponse;
import org.alpha.health.gov.ClinicalTrialsGovClient;

import java.util.Collections;

/**
 * package-protected impls
 */
public class GovAPIBackedHealthDaoServiceImpls implements HealthDaoService {

    ClinicalTrialsGovClient clinicalTrialsGovClient = new ClinicalTrialsGovClient();
    @Override
    public QueryClinicalTrialsResponse queryClinicalTrials(final QueryClinicalTrialsRequest request) {

        // call clinical.gov to get clinical trial data.
        String response = clinicalTrialsGovClient.getStudiesWithSpecifiedFields(
            request.condition + "+" + request.getLocation());

        System.out.println(response);
        return QueryClinicalTrialsResponse.builder().clinicalTrialList(Collections.emptyList()).build();
    }
}
