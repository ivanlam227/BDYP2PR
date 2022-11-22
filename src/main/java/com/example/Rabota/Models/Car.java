package com.example.Rabota.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.crypto.Data;
import java.sql.Date;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String marks;
    private String vin;
    private int numberengen;
    private String year;
    private String color;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String color() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Car(String marks, String vin, int numberengen, String year, String color) {
        this.marks = marks;
        this.vin = vin;
        this.numberengen = numberengen;
        this.year = year;
            this.color = color;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getNumberengen() {
        return numberengen;
    }

    public void setNumberengen(int numberengen) {
        this.numberengen = numberengen;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public Car() {
    }
}
