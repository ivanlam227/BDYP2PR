package com.example.Rabota.Models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String lastname;
    private String name;
    private String middlename;
    private Date birthday;
    private int expetienxs;

    public long getId() {return id;}

    public void setId(long id) {
        this.id = id;}

    public String getLastname() {return lastname;}

    public void setLastname(String lastname) {this.lastname = lastname;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public String getMiddlename() {return middlename;}

    public void setMiddlename(String middlename) {this.middlename = middlename;}

    public Date getBirthday() {return birthday;}

    public void setBirthday(Date birthday) {this.birthday = birthday;}

    public int getExpetienxs() {return expetienxs;}

    public void setExpetienxs(int expetienxs) {this.expetienxs = expetienxs;}

    public Employee() {}

    public Employee(String lastname, String name, String middlename, Date birthday, int expetienxs) {
        this.lastname = lastname;
        this.name = name;
        this.middlename = middlename;
        this.birthday = birthday;
        this.expetienxs = expetienxs;
    }


}

