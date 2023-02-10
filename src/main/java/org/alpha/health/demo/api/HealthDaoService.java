package org.alpha.health.demo.api;

import org.alpha.health.demo.model.QueryClinicalTrialsRequest;
import org.alpha.health.demo.model.QueryClinicalTrialsResponse;

/**
 * Health domain service interface
 */
public interface HealthDaoService {

    /**
     * queries the trials data
     * @param QueryClinicalTrialsRequest
     * @return
     */
    QueryClinicalTrialsResponse queryClinicalTrials(QueryClinicalTrialsRequest request);
}
