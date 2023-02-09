package org.alpha.health.demo.impls;

import org.alpha.health.demo.api.HealthDomainService;
import org.alpha.health.demo.model.QueryClinicalTrialsResponse;
import org.alpha.health.demo.model.QueryPersonalPredictionRequest;

/**
 * package-protected impls
 */
public class HealthDomainServiceImpls implements HealthDomainService {
    @Override
    public QueryClinicalTrialsResponse queryClinicalTrials(
            final QueryPersonalPredictionRequest queryPersonalPredictionRequest) {
        return null;
    }
}
