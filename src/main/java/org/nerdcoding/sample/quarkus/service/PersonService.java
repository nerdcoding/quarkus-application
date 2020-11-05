package org.nerdcoding.sample.quarkus.service;

import org.nerdcoding.sample.quarkus.persistence.model.Person;
import org.nerdcoding.sample.quarkus.persistence.repository.PersonRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@ApplicationScoped
public class PersonService {

    private final PersonRepository personRepository;

    @Inject
    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Optional<Person> findPersonByLastName(final String lastName) {
        return personRepository.findByLastName(lastName);
    }

    public List<Person> findAllPersons() {
        return StreamSupport.stream(personRepository.findAll().spliterator(),false)
                .collect(Collectors.toList());
    }
}
