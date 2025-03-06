package ru.Krivi4Unity.library.models;

import javax.validation.constraints.*;

public class Book {

    private int id;

    @NotEmpty(message = "Название не может быть пустым")
    private String title;


    @Size(min = 5, max = 50, message = "Инициалы автора книги не могут быть меньше 5 и больше 50")
    private String author;

    @NotNull(message = "Год не может быть пустым")
    @Min(value = 0, message = "Год не может быть меньше 0")
    @Max(value = 2025, message = "Год не может быть больше текущего")
    private Integer year;

    public Book(int id, String title, String author, Integer year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public Book(){

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
    public Integer getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }


}
