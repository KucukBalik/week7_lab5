package ie.atu.cicdlab5;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person create(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    public List<Person> findAll() {

        return personRepository.findAll();

    }

    public Person findById(String id) {
        return personRepository.findByEmployeeId(id).orElseThrow(() -> new IllegalArgumentException("Person with id " + id + "not found"));
    }


}
