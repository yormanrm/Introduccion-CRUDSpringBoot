package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data //agrega todos los metodos get, set, equals, hascode etc usando la dependencia lombok
@Entity // convierte la clase a una de entidad JPA
@Table(name = "person")
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    private String name;
    private String lastname;    
    private String email;
    private String phone;
}
