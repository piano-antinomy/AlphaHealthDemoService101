package org.alpha.health.demo.api;

import org.alpha.health.demo.model.QueryClinicalTrialsResponse;
import org.alpha.health.demo.model.QueryPersonalPredictionRequest;

/**
 * Health domain service interface
 */
public interface HealthDomainService {

    /**
     * queries the trials data
     * @param queryPersonalPredictionRequest
     * @return
     */
    QueryClinicalTrialsResponse queryClinicalTrials(
            QueryPersonalPredictionRequest queryPersonalPredictionRequest);
}
