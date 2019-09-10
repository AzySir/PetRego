package com.petrego.PetRego.model;

import javax.persistence.*;



/**
 * Scope: This class handles the pet information
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */

@Entity
@Table(name = "pets")
@EntityListeners(Pet.class)
public class Pet {


    //Pet Id for Searching up - use of Api
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //Pet Name
    @Column(name = "pet_name", nullable = false)
    private String pet_name;

    //Type of Pet - Dog / Cat / Chicken / Snake
    @Column(name = "pet_type", nullable = false)
    private String pet_type;

    //Food - Bones / Fish / Corn / Mice
    @Column(name = "pet_food", nullable = false)
    private String pet_food;

    //Age as part of v2 API
    @Column(name = "age")
    private int age;

    //Owner_id to link back to owner. Also a search value via api
    @Column(name = "owner_id")
    private Long owner_id;

    //<!-------- Constructors ---------->

        //Empty Instance
    public Pet() {

    }

    //Constructor for V1 Purpose
    public Pet(String pet_name, String pet_type, String pet_food) {
        this.pet_name = pet_name;
        this.pet_type = pet_type;
        this.pet_food = getFoodType(pet_type);
    }

    //Constructor vor V2 Purpose
    public Pet(String pet_name, String type, String pet_food, int age, Long owner_id) {
        this.pet_name = pet_name;
        this.pet_type = type;
        this.pet_food = getFoodType(type);
        this.age = age;
        this.owner_id = owner_id;
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
        return pet_name;
    }

    public void setPetName(String pet_name) {
        this.pet_name = pet_name;
    }

    public String getType() {
        return pet_type;
    }

    public void setType(String type) {
        this.pet_type = type;
    }

    public String getFood() {
        return pet_food;
    }

    public void setFood(String pet_food) {
        this.pet_food = pet_food;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(Long owner_id) {
        this.owner_id = owner_id;
    }


}
