package ru.Krivi4Unity.library.models;

import javax.validation.constraints.*;

public class Reader {

    private int id;

    @NotNull(message = "Номер читательского билета не может быть пустым ")
    @Min(value = 1, message = "Номер читательского билета не может быть меньше 0")
    private int readerTicketNumber;

    @Size(min = 2, max = 30, message = "Имя не может быть меньше 2 и больше 30")
    private String name;

    @Size(min = 2, max = 30, message = "Фамилия не может быть меньше 2 и больше 30")
    private String surname;

    @Size(min = 2, max = 30, message = "Отчество не может быть меньше 2 и больше 30")
    private String patronymic;

    @NotNull(message = "Возраст не может быть пустым")
    @Min(value = 0, message = "Возраст не может быть меньше 0")
    private Integer age;

    @Pattern(regexp = "^(Мужской|Женский)$", message = "Пол должен быть 'Мужской' или 'Женский', других гендеров не существует")
    private String gender;


    @NotEmpty(message = "Email не может быть пустым")
    @Email(message = "Email должен быть действительным")
    private String email;


    public Reader(int id, int readerTicketNumber, String name, String surname, String patronymic, Integer age, String gender, String email) {
        this.id = id;
        this.readerTicketNumber = readerTicketNumber;
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.gender = gender;
        this.email = email;
    }

    public Reader(){

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getReaderTicketNumber() {
        return readerTicketNumber;
    }
    public void setReaderTicketNumber(int readerTicketNumber) {
        this.readerTicketNumber = readerTicketNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
