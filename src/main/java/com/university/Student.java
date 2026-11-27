package com.university;

import javafx.beans.property.*;

/** Observable student model used directly by JavaFX TableView columns. */
public final class Student {
    private final IntegerProperty id = new SimpleIntegerProperty(this, "id");
    private final StringProperty registrationNumber = new SimpleStringProperty(this, "registrationNumber", "");
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty email = new SimpleStringProperty(this, "email", "");
    public Student(int id, String reg, String first, String last, String email) {
        this.id.set(id); registrationNumber.set(reg); firstName.set(first); lastName.set(last); this.email.set(email);
    }
    public IntegerProperty idProperty(){return id;} public StringProperty registrationNumberProperty(){return registrationNumber;}
    public StringProperty firstNameProperty(){return firstName;} public StringProperty lastNameProperty(){return lastName;}
    public StringProperty emailProperty(){return email;}
    public int getId(){return id.get();} public String getRegistrationNumber(){return registrationNumber.get();}
    public String getFirstName(){return firstName.get();} public String getLastName(){return lastName.get();} public String getEmail(){return email.get();}
}
