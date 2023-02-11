package org.alpha.health.demo.impls;

import org.alpha.health.demo.api.HealthDaoService;
import org.alpha.health.demo.model.QueryClinicalTrialsRequest;
import org.alpha.health.demo.model.QueryClinicalTrialsResponse;
import org.alpha.health.gov.ClinicalTrialsGovClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;

/**
 * package-protected impls
 */
public class GovAPIBackedHealthDaoServiceImpls implements HealthDaoService {

    private static Logger LOGGER = LogManager.getLogger(GovAPIBackedHealthDaoServiceImpls.class);
    final ClinicalTrialsGovClient clinicalTrialsGovClient = new ClinicalTrialsGovClient();
    @Override
    public QueryClinicalTrialsResponse queryClinicalTrials(final QueryClinicalTrialsRequest request) {

        // call clinical.gov to get clinical trial data.
        String response = clinicalTrialsGovClient.getStudiesWithSpecifiedFields(
            request.condition + "+" + request.getLocation());

        LOGGER.info("response: " + response);
        return QueryClinicalTrialsResponse.builder().clinicalTrialList(Collections.emptyList()).build();
    }
}
