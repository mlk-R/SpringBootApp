package ru.malik.spring.LibrarySpringBoot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name ="title")
    @NotEmpty(message = "имя книги не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя книги должно быть от 2 до 100 символов")
    private String title;

    @Column(name = "author")
    @NotEmpty(message = "Автор не должно быть пустым")
    @Size(min = 2, max = 100, message = "Автор должно быть от 2 до 100 символов")
    private String author;

    @Column(name = "year")
    @Min(value = 1500, message = "Год должен быть больше 1500")
    private int year;

    @ManyToOne
    @JoinColumn (name = "person_id", referencedColumnName = "id")
    private Person owner;


    public Book() {
    }

    public Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Person getOwner() {
        return owner;
    }
    public void setOwner(Person owner) {
        this.owner = owner;
    }
}
