package fr.supavenir.springsoap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fr.supavenir.springsoap.client.PersonClient;
import fr.supavenir.springsoap.gen.GetPersonResponse;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner lookup(PersonClient client) {
        return args -> {
            String person = "Theo";

            if (args.length > 0) {
                person = args[0];
            }
            // Appel SOAP depuis Java et recup de la réponse en java
            GetPersonResponse response = client.getPerson(person);
            // Test du contenu de la réponse
            System.err.println(response.getPerson().getName());
        };
    }

}