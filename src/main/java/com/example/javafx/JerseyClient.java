package com.example.javafx;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class JerseyClient {

    static Logger log = Logger.getLogger(JerseyClient.class.getName());

    public String metar (String iaco) {
        BasicConfigurator.configure();

        log.info("Attempting to retrieve the metar " + iaco);
        try {
            Client client = ClientBuilder.newClient();
            WebTarget webTarget = client.target("https://api.checkwx.com/bot/metar/"+iaco);
            Invocation.Builder invocationBuilder =  webTarget.request(MediaType.APPLICATION_JSON);
            invocationBuilder.header("X-API-Key", "");
            Response response = invocationBuilder.get();

            if (response.getStatus() == 200) {
                return response.readEntity(String.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error fetching data";
    }
}
