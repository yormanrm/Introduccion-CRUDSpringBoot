package mx.com.gm.domain;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data //agrega todos los metodos get, set, equals, hascode etc usando la dependencia lombok
@Entity // convierte la clase a una de entidad JPA
@Table(name = "person")
public class Person implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id // Le dice a netbeans que es la llave primaria e id de esta tabla
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    
    @NotEmpty //validacion para campo vacio para cadenas
    private String name;
    
    @NotEmpty
    private String lastname;    
    
    @NotEmpty
    @Email // valida que el texto ingresado este en formato email
    private String email;
            
    // @NotNull sirve para validar campos nulls ( no es lo mismo que una cadena vacia )
    private String phone;
}
