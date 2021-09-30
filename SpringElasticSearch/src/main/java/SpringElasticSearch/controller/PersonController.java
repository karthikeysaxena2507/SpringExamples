package SpringElasticSearch.controller;

import SpringElasticSearch.document.Person;
import SpringElasticSearch.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void save(@RequestBody Person person) {
        personService.save(person);
    }

    @GetMapping
    public Person findById(@RequestParam String id) {
        return personService.findById(id);
    }
}
