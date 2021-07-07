package fr.supavenir.springsoap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;



import fr.supavenir.springsoap.gen.Person;

@Component
public class PersonRepository {

    private static final Map<String, Person> persons = new HashMap<>();

    @PostConstruct
    public void initData() {
        Person theo = new Person();
        theo.setName("marie");
        theo.setPrenom("theo");
     

        persons.put(theo.getName(), theo);

    }

    public static Person findPerson(String name) {
        Assert.notNull(name, "The persons name must not be null");
        return persons.get(name);
    }
    
    public List<Person> findAllPersons() {
    	return new ArrayList<Person> ( persons.values() );
    }
    
    
    
}
