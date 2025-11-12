package ie.atu.cicdlab5;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findById(Long id);

    Optional<Person> findByEmployeeId(String employeeId);

    Person removePersonById(Long id);

}
