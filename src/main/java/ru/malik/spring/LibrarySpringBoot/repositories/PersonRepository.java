package ru.malik.spring.LibrarySpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.malik.spring.models.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query("SELECT p FROM Person p JOIN p.books b WHERE b.id = :bookId")
    Optional<Person> findBookOwnerByBookId(@Param("bookId") int bookId);

    Optional<Person> findByFullName(String fullName);
}
