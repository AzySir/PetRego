package com.petrego.PetRego.model;

import javax.persistence.*;

@Entity
@Table(name = "owners")
@EntityListeners(Owner.class)
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    //Owner first name
    @Column(name = "first_name", nullable = false)
    private String first_name;

    //Owner last name
    @Column(name = "last_name", nullable = false)
    private String last_name;

    //Owner Date of Birth
    @Column(name = "dob", nullable = false)
    private String dob;

    //Owners Email
    @Column(name = "email", nullable = false)
    private String email;

    //Owners Phone Number
    @Column(name = "phone_number", nullable = false)
    private Long phone_number;

    //Owners Pets Id
    @Column(name = "pet", nullable = false)
    private String pets;


}
