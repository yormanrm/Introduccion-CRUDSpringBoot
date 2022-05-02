package mx.com.gm.web;

import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.com.gm.domain.Person;
import mx.com.gm.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class MainController {
    
    @Autowired
    private PersonService personservice;// inyecta una instancia del servicio de implementacion crud en el controlador
    
    @GetMapping("/")
    public String Main(Model model){
        var people = personservice.ListPeople();
        log.info("Executing Spring MVC");
        model.addAttribute("people", people);
        return "index";
    }
    
    
    
    
    
    @GetMapping("/add")
    public String add(Person person){
        return "modify";
    }
    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors){ // @Valid hace uso de Validators
        if(errors.hasErrors()){ //comprueba si hay errores de validacion
            return "modify";
        }
        personservice.savePerson(person);
        return "redirect:/";
    }
    
    
    
    
    @GetMapping("/modify/{idPerson}")
    public String modify(Person person, Model model){
        person = personservice.findPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }
    
    
    
    
    @GetMapping("/delete/{idPerson}")
    public String delete(Person person){
        personservice.deletePerson(person);
        return "redirect:/";
    }
    
    /* QUERY PARAM
    @GetMapping("/delete")
    public String delete(Person person){
        personservice.deletePerson(person);
        return "redirect:/";
    }
    */
}
 