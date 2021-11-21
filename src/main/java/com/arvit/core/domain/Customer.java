package com.arvit.core.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
    int id;
    String firstName;
    String lastName;
    Date birthDate;
    int nrBeverages;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public Customer() { }

    public Customer(int id, String firstName, String lastName, Date birthDate, int nrBeverages) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.nrBeverages = nrBeverages;
    }

    public Customer(int id, String firstName, String lastName, String birthDate) throws ParseException {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = sdf.parse(birthDate);
        this.nrBeverages = 0;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }

    public Date getBirthDate() { return birthDate; }

    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate;
    }
}
