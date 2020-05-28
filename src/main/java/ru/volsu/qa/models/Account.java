package ru.volsu.qa.models;

import lombok.*;

@Data
public class Account {

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private String dayBirth;
    private String monthBirth;
    private String yearBirth;

    private String address;
    private String city;
    private String state;
    private String postCode;
    private String country;
    private String phone;



    public Account() {
        this.firstName ="Иван" ;
        this.lastName ="Иванов" ;
        this.password = "QWERTY!@#$";
        this.dayBirth="1";
        this.monthBirth="1";
        this.yearBirth="1999";
        this.address = "selo";
        this.city ="Albuquerque";
        this.state = "New Mexico";
        this.postCode = "87001";
        this.country = "United States";
        this.phone = "12345678910";
    }

    public String getDayBirth() {
        return dayBirth;
    }

    public String getMonthBirth() {
        return monthBirth;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public String getAddress() { return address;  }

    public String getCity() { return city; }

    public String getState() {return state;   }

    public String getPostalCode() {  return postCode;  }

    public String getCountry() {  return country; }

    public String getPhone() { return phone; }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String s) {
        email=s;
    }

    public String getEmail() {
        return email;
    }



}
