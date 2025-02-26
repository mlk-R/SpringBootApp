package ru.malik.spring.LibrarySpringBoot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.malik.spring.models.Book;
import ru.malik.spring.models.Person;
import ru.malik.spring.repositories.BooksRepository;
import ru.malik.spring.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class BookService {
    private final BooksRepository booksRepository;
    private final PersonRepository personRepository;

    public BookService(BooksRepository booksRepository, PersonRepository personRepository) {
        this.booksRepository = booksRepository;
        this.personRepository = personRepository;
    }

    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    public Book findOne(int id) {
        Optional<Book> book = booksRepository.findById(id);
        return book.orElse(null);
    }

    @Transactional
    public Book save(Book book) {
        return booksRepository.save(book);
    }

    @Transactional
    public Book update(int id, Book book) {
        return booksRepository.save(book);
    }

    @Transactional
    public void delete(int id) {
        booksRepository.deleteById(id);
    }

    @Transactional
    public Optional<Person> getBookOwner(int bookId) {
        return personRepository.findBookOwnerByBookId(bookId);
    }
    @Transactional
    public void release(int id) {
        Optional<Book> optionalBook = booksRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setOwner(null);
            booksRepository.save(book);
        }
    }

    @Transactional
    public void assign(int bookId, Person selectedPerson) {
        Optional<Book>  optionalBook = booksRepository.findById(bookId);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setOwner(selectedPerson);
            booksRepository.save(book);
        }
    }
}