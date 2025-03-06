package ru.Krivi4Unity.library.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.Krivi4Unity.library.models.Reader;

import java.util.List;

@Repository
public class ReaderDAO {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReaderDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    ////////
    //READ
    ////////

    public List<Reader> getAllReaders() {

        return jdbcTemplate.query("SELECT * FROM reader", new BeanPropertyRowMapper<>(Reader.class));
    }

    public Reader getReaderById(int id) {

        return jdbcTemplate.queryForObject("SELECT * FROM reader WHERE id = ?",
                new BeanPropertyRowMapper<>(Reader.class), id);
    }

    /////////
    //CREATE
    /////////

    public void addReader(Reader reader) {
        jdbcTemplate.update("INSERT INTO reader(readerTicketNumber, name, surname, " +
                        "patronymic, age, gender, email) VALUES(?,?,?,?,?,?,?)",
                reader.getReaderTicketNumber(), reader.getName(), reader.getSurname(),
                reader.getPatronymic(), reader.getAge(), reader.getGender(),
                reader.getEmail());
    }

    /////////
    //UPDATE
    ////////

    public void updateReader(int id, Reader updatedReader) {
        jdbcTemplate.update("UPDATE reader SET readerTicketNumber=?, name=?, surname=?, " +
                        "patronymic=?, age=?, gender=?, email=? WHERE id=?",
                updatedReader.getReaderTicketNumber(), updatedReader.getName(), updatedReader.getSurname(),
                updatedReader.getPatronymic(), updatedReader.getAge(), updatedReader.getGender(),
                updatedReader.getEmail(),id);
    }

    /////////
    //DELETE
    /////////

    public void deleteReader(int id) {
        jdbcTemplate.update("DELETE FROM reader WHERE id=?", id);
    }
}
