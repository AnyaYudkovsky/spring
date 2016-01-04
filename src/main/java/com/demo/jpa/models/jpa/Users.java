package com.demo.jpa.models.jpa;

/**
 * Created by anyayudkovsky on 12/30/15.
 */



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    protected Users() {}

    public Users(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = "empty";
    }

    public Users(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
                "Users[id=%d, firstName='%s', lastName='%s', email='%s']",
                id, firstName, lastName, email);
    }

}