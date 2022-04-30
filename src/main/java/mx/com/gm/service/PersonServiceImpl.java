package mx.com.gm.service;

import java.util.List;
import mx.com.gm.dao.IPersonDAO;
import mx.com.gm.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // Permite inyectar este servicio al controlador
public class PersonServiceImpl implements PersonService {

    @Autowired
    private IPersonDAO persondao; // inyeccion del modelo para las consultas
    
    @Override
    @Transactional (readOnly = true) //Transactions sirve verficar errores, si marca error hace un rollback cancelando las acciones y si es exitoso hace un commit en las tablas afectadas
    public List<Person> ListPeople() {
        return (List<Person>) persondao.findAll(); //devuelve un objeto pero se castea a una lista
    }

    @Override
    @Transactional
    public void savePerson(Person person) {
        persondao.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        persondao.delete(person);
    }

    @Override
    @Transactional (readOnly = true)
    public Person findPerson(Person person) {
        return persondao.findById(person.getIdPerson()).orElse(null); // devuelve null si no encuentra la persona
    }
    
}
