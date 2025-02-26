package ru.malik.spring.LibrarySpringBoot.service;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.spring.models.Book;
import ru.malik.spring.models.Person;
import ru.malik.spring.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional (readOnly = true)
public class PeopleService {

    private final PersonRepository peopleRepository;

    @Autowired
    public PeopleService(PersonRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> foundPerson = peopleRepository.findById(id);
        return foundPerson.orElse(null);
    }

    public Optional<Person> findByFullName(String fullName) {
        return peopleRepository.findByFullName(fullName);
    }

    @Transactional
    public Person save(Person person) {
        return peopleRepository.save(person);
    }

    @Transactional
    public Person update(int id, Person person) {
        return peopleRepository.save(person);
    }

    @Transactional
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }
    @Transactional
    public List<Book> getBooksByPersonId(int id) {
        Person person = peopleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Person with id " + id + " not found"));
        return person.getBooks();
    }
}
