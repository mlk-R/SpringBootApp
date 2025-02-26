package ru.malik.spring.LibrarySpringBoot.util;


import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import ru.malik.spring.models.Person;
import ru.malik.spring.service.PeopleService;

@Component
public class PersonValidator {

    private final PeopleService peopleService;

    public PersonValidator(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        if (peopleService.findByFullName(person.getFullName()).isPresent()) {
            errors.rejectValue("fullName", "", "Человек с таким ФИ существует");
        }
    }
}
