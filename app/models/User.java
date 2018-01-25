package models;

import java.util.Date;
import java.util.List;

public class User {

    //private static final long serialVersionUID = 1L;


    private String name;
    private String lastname;
    private int age;
    private String location;
    private String userType;
    private List publicaciones;



    public User(String name, String lastname, int age, String location, String userType) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.location = location;
        this.userType = userType;

    }
}
