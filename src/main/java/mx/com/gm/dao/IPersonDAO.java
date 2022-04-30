package mx.com.gm.dao;

import mx.com.gm.domain.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person, Long>{} //interace con los metodos de entidad de un crud 
