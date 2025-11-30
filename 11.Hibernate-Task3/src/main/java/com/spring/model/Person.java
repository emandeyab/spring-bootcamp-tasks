package com.spring.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "person")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person")
    private Passport passport;

    //construtor without id and passport
    public Person(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person { " +
                "id = " + id +
                ", First Name = " + firstName +
                ", Last Name = " + lastName +
                ", date Of Birth = " + dateOfBirth +
                ", passport numner = " + passport.getPassportNo() +
                 "}";
    }
}
