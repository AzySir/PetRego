package com.petrego.PetRego.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.petrego.PetRego.repository.PetRepository;

import javax.persistence.*;



/**
 * Scope: This class handles the pet information
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */

@Entity //Create Entity
@Table(name = "pets") //Create a Table for owners in H2
@EntityListeners(Pet.class)
public class Pet {


    //Pet Id for Searching up - use of Api
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Pet Name
    @Column(name = "pet_name", nullable = false)
    private String petName;

    //Type of Pet - Dog / Cat / Chicken / Snake
    @Column(name = "pet_type", nullable = false)
    private String petType;

    //Food - Bones / Fish / Corn / Mice
    @Column(name = "pet_food")
    private String petFood;

    //Age as part of v2 API
    @Column(name = "age")
    private int age;

    //Owner_id to link back to owner. Also a search value via api
    @Column(name = "owner_id")
    private Long ownerId;

    //<!-------- Constructors ---------->

    //Empty Instance
    public Pet() {

    }

    //Constructor for V1 Purpose
    public Pet(String petName, String petType, String petFood) {
        this.petName = petName;
        this.petType = petType;
        this.petFood = getFoodType(petType);
    }

    //Constructor for V2 Purpose
    public Pet(String petName, String petType, String petFood, int age, Long ownerId) {
        this.petName = petName;
        this.petType = petType;
        this.petFood = getFoodType(petType);
        this.age = age;
        this.ownerId = ownerId;
    }

    //<------ Getter and Setters for Above Variables ------>

    public String getFoodType(String type) {
        String food;
        switch(type) {
            case "Dog":
                food = "Bones";
                break;
            case "Cat":
                food = "Fish";
                break;
            case "Chicken":
                food = "Corn";
                break;
            case "Snake":
                food = "Mice";
                break;
            default:
                food = "TBC";
        }
        return food;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    public String getPetFood() {
        return petFood;
    }

    public void setPetFood(String petFood) {
        this.petFood = petFood;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }




    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", pet_name='" + petName + '\'' +
                ", pet_type='" + petType + '\'' +
                ", pet_food='" + petFood + '\'' +
                ", age=" + age +
                ", owner_id=" + ownerId +
                '}';
    }
}
