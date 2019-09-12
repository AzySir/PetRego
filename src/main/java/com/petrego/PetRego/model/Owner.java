package com.petrego.PetRego.model;

import javax.persistence.*;

/**
 * @Scope: This class handles the Owner information
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */

@Entity //Create Entity
@Table(name = "owners") //Create a Table for owners in H2
@EntityListeners(Owner.class) //Set the entity listener
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Owner first name
    @Column(name = "first_name", nullable = false)
    private String firstName;

    //Owner last name
    @Column(name = "last_name", nullable = false)
    private String lastName;

    //Owner Date of Birth
    @Column(name = "dob", nullable = false)
    private String dob;

    //Owners Email
    @Column(name = "email", nullable = false)
    private String email;

    //Owners Phone Number
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    //Owners Pets Id
    @Column(name = "pets", nullable = false)
    private String pets;


    //<--------------- Constructors ------------------>

    public Owner() { }

    public Owner(String firstName, String lastName, String dob, String email, String phoneNumber, String pets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.pets = pets;
    }

    //Construct for V1 API Services
    public Owner(String firstName, String lastName, String dob, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.email = email;
    }

    //<------------- End of Constructors --------------->

    //<-------------- GET + SETTERS --------------------->


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phone_number) {
        this.phoneNumber = phone_number;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", phone_number='" + phoneNumber + '\'' +
                ", pets='" + pets + '\'' +
                '}';
    }

    //<!---------- End of Getters & Setters ---------->
}
