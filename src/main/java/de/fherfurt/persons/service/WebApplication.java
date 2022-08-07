package de.fherfurt.persons.service;

import de.fherfurt.persons.service.resources.BaseResource;
import org.eclipse.jetty.server.Server;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

/**
 * @Author Prof. Dr. Steffen Avemarg
 * @Version 2.0.0.0
 * Main is to start and Log the information of the Jetty Server in the Docker
 */
public class WebApplication {
    public static final String BASE_URI = "http://localhost:8080/";

    public static Server startServer() {
        final ResourceConfig config = new ResourceConfig(BaseResource.class);
        final Server server = JettyHttpContainerFactory.createServer(URI.create(BASE_URI), config);
        return server;
    }


    public static void main(String[] args) {

        Logger LOG = LoggerFactory.getLogger(WebApplication.class);

        try {
            final Server server = startServer();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    LOG.info("Shutting down the application...");
                    server.stop();
                    LOG.info("Done, exit.");
                } catch (Exception e) {
                    LOG.error(null, e);
                }
            }));

            LOG.info("Application started. -- Stop the application using CTRL+C\n");

            // block and wait shut down signal, like CTRL+C
            Thread.currentThread().join();

        } catch (InterruptedException ex) {
            LOG.error(null, ex);
        }
    }
}
