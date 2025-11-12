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

    public Person findById(Long id) {
        return personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person with id " + id + "not found"));
    }

    public Person update(Long id, Person person) {
        Person toUpdate = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person with id " + id + " not found"));
        toUpdate.setName(person.getName());
        toUpdate.setEmail(person.getEmail());
        toUpdate.setPosition(person.getPosition());
        toUpdate.setDepartment(person.getDepartment());
        return personRepository.save(toUpdate);
    }

    public void delete(Long id) {
        Person toDelete = personRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Person with id " + id + " not found"));
        personRepository.delete(toDelete);
    }



}
