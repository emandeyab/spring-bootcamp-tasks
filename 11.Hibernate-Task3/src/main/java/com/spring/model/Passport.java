package com.spring.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "passport")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "passport_number")
    private String passportNo;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id")
    private Person person;

    //construtor without id and person
    public Passport(String passportNo) {
        this.passportNo = passportNo;
    }
}
