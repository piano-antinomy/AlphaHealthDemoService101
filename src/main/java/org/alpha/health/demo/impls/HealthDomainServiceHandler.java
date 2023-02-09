package org.alpha.health.demo.impls;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.io.OutputStream;

public class HealthDomainServiceHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange httpExchange) throws IOException {
        if ("GET".equals(httpExchange.getRequestMethod())) {

            OutputStream outputStream = httpExchange.getResponseBody();
            
            StringBuilder htmlBuilder = new StringBuilder();

            htmlBuilder
                    .append("<html>")
                    .append("<body>")
                    .append("<h1>")
                    .append("Hello ")
                    .append("any")
                    .append("</h1>")
                    .append("</body>")
                    .append("</html>");

            String htmlResponse = htmlBuilder.toString();

            // this line is a must to set the length
            httpExchange.sendResponseHeaders(200, htmlResponse.length());
            outputStream.write(htmlResponse.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
