package fr.supavenir.springsoap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import fr.supavenir.springsoap.gen.GetPersonRequest;
import fr.supavenir.springsoap.gen.GetPersonResponse;

@Endpoint
public class PersonEndpoint {

    private static final String NAMESPACE_URI = "http://www.supavenir.fr/springsoap/gen";

    @Autowired
    public PersonEndpoint(PersonRepository personRepository) {
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPersonRequest")
    @ResponsePayload
    public GetPersonResponse getCountry(@RequestPayload GetPersonRequest request) {
        GetPersonResponse response = new GetPersonResponse();
        response.setPerson(PersonRepository.findPerson(request.getName()));
        return response;
    }
}

