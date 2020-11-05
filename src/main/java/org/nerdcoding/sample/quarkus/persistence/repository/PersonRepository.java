package org.nerdcoding.sample.quarkus.persistence.repository;

import org.nerdcoding.sample.quarkus.persistence.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    Optional<Person> findByLastName(final String lastName);

}
