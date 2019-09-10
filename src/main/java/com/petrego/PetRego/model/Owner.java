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
    @Column(name = "pets", nullable = false)
    private String pets;


    //<--------------- Constructors ------------------>

    public Owner() { }

    public Owner(String first_name, String last_name, String dob, String email, Long phone_number, String pets) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.email = email;
        this.phone_number = phone_number;
        this.pets = pets;
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
        return first_name;
    }

    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public void setLastName(String last_name) {
        this.last_name = last_name;
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

    public Long getPhoneNumber() {
        return phone_number;
    }

    public void setPhoneNumber(Long phone_number) {
        this.phone_number = phone_number;
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
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", dob='" + dob + '\'' +
                ", email='" + email + '\'' +
                ", phone_number=" + phone_number +
                ", pets='" + pets + '\'' +
                '}';
    }

    //<!---------- End of Getters & Setters ---------->
}
