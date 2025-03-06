package ru.Krivi4Unity.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.Krivi4Unity.library.models.Book;

import java.util.List;

@Repository
public class BookDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    ////////
    //READ
    ////////

    public List<Book> getAllBooks() {

      return jdbcTemplate.query("SELECT * FROM book", new BeanPropertyRowMapper<>(Book.class));
    }

    public Book getBookById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?",
                new BeanPropertyRowMapper<>(Book.class), id);
    }

    /////////
    //CREATE
    /////////

    public void addBook(Book book) {
        jdbcTemplate.update("INSERT INTO book (title, author, year) VALUES (?, ?, ?)",
                book.getTitle(), book.getAuthor(), book.getYear());
    }

    /////////
    //UPDATE
    ////////

    public void updateBook(int id, Book updatedBook) {
        jdbcTemplate.update("UPDATE book SET title=?, author=?, year=? WHERE id=?",
                updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getYear(), id);
    }

    /////////
    //DELETE
    /////////

    public void deleteBook(int id) {
        jdbcTemplate.update("DELETE FROM book WHERE id=?", id);
    }
}
