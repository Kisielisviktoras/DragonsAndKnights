package com.dak.api.client;

import com.dak.api.resolver.WeatherReportDTOMessageBodyReader;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Base client REST endpoint for application
 *
 * @author Saji
 */
public class AbstractClient {

    protected WebTarget getWebTarget() {
        ClientConfig config = new ClientConfig();
        config.register(JacksonFeature.class);
        config.register(WeatherReportDTOMessageBodyReader.class);
        Client client = ClientBuilder.newClient(config);
        return client.target(getBaseURI());
    }

    protected String getBaseURI() {
        return "http://www.dragonsofmugloar.com";
    }
}
