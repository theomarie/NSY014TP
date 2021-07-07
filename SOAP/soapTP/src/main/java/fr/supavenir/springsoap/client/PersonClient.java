package fr.supavenir.springsoap.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import fr.supavenir.springsoap.gen.GetPersonRequest;
import fr.supavenir.springsoap.gen.GetPersonResponse;

public class PersonClient extends WebServiceGatewaySupport {

    private static final Logger logger = LoggerFactory.getLogger(PersonClient.class);

    public GetPersonResponse getPerson(String person) {

        GetPersonRequest request = new GetPersonRequest();
        request.setName(person);
        logger.info("Demande d'information pour " + person);
        GetPersonResponse response =
                (GetPersonResponse) getWebServiceTemplate().marshalSendAndReceive(request);

        return response;
    }

}
