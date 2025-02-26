package ru.malik.spring.LibrarySpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.malik.spring.models.Book;

@Repository
public interface BooksRepository extends JpaRepository<Book, Integer> {

}
