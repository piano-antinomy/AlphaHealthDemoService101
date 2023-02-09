package org.alpha.health;

import com.sun.net.httpserver.HttpServer;
import org.alpha.health.demo.impls.HealthDomainServiceHandler;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainService {
    public static void main(String[] args) {

        final Executor threadPoolExecutor = Executors.newFixedThreadPool(10);

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress("localhost", 7076), 0);

            server.createContext("/test", new HealthDomainServiceHandler());
            server.setExecutor(threadPoolExecutor);

            server.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}