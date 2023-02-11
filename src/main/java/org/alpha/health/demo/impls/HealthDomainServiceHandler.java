package org.alpha.health.demo.impls;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import org.alpha.health.demo.api.HealthDaoService;
import org.alpha.health.demo.model.QueryClinicalTrialsRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class HealthDomainServiceHandler implements HttpHandler {
    private static Logger LOGGER = LogManager.getLogger(HealthDomainServiceHandler.class);
    final ObjectMapper objectMapper = new ObjectMapper();
    final HealthDaoService dao = new GovAPIBackedHealthDaoServiceImpls();
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if ("GET".equals(httpExchange.getRequestMethod())) {

            final InputStream inputStream = httpExchange.getRequestBody();
            final OutputStream outputStream = httpExchange.getResponseBody();

            try {
                final QueryClinicalTrialsRequest queryClinicalTrialsRequest
                    = objectMapper.readValue(inputStream, QueryClinicalTrialsRequest.class);

                LOGGER.info("getting input: " + queryClinicalTrialsRequest);

                String response = dao.queryClinicalTrials(queryClinicalTrialsRequest).toString();

                LOGGER.info("final response: " + response);

                // this line is a must to set the length
                httpExchange.sendResponseHeaders(200, response.length());
                outputStream.write(response.getBytes());
                outputStream.flush();
                outputStream.close();
            } catch (final Exception e) {
                LOGGER.error("exception: " + e);

                String errorResponse = "Server Errors";
                httpExchange.sendResponseHeaders(500, errorResponse.length());
                outputStream.write(errorResponse.getBytes());
                outputStream.flush();
                outputStream.close();
            } finally {
                outputStream.close();
            }
        }
    }
}
