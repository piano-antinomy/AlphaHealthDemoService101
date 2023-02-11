package org.alpha.health;

import com.sun.net.httpserver.HttpServer;
import org.alpha.health.demo.impls.HealthDomainServiceHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainService {

    private final static Logger LOGGER = LogManager.getLogger(MainService.class);

    public static void main(String[] args) {

        final Executor threadPoolExecutor = Executors.newFixedThreadPool(10);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 7076), 0);

            server.createContext("/test", new HealthDomainServiceHandler());
            server.createContext("/clinical-trials/query", new HealthDomainServiceHandler());
            server.setExecutor(threadPoolExecutor);

            LOGGER.info("Starting the server");
            server.start();
        } catch (final Exception e) {

            LOGGER.error("exception " + e);
            throw new RuntimeException(e);
        }

    }
}