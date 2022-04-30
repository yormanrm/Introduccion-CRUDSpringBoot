package mx.com.gm.service;

import java.util.List;
import mx.com.gm.domain.Person;

public interface PersonService {
    
    public List<Person> ListPeople();
    public void savePerson(Person person);
    public void deletePerson(Person person);
    public Person findPerson(Person person);
    
}
