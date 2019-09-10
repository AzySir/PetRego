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
    @Column(name = "type", nullable = false)
    private String type;

    //Food - Bones / Fish / Corn / Mice
    @Column(name = "food", nullable = false)
    private String food;

    //Age as part of v2 API
    @Column(name = "age", nullable = false)
    private int age;

    //Owner_id to link back to owner. Also a search value via api
    @Column(name = "owner_id", nullable = false)
    private Long owner_id;

    //<!-------- Constructors ---------->

    //Empty Instance
    public Pet() {

    }

    //Constructor for V1 Purpose
    public Pet(String pet_name, String type, String food) {
        this.pet_name = pet_name;
        this.type = type;
        this.food = getFood(type);
    }

    //Constructor vor V2 Purpose
    public Pet(String pet_name, String type, String food, int age, Long owner_id) {
        this.pet_name = pet_name;
        this.type = type;
        this.food = getFood(type);
        this.age = age;
        this.owner_id = owner_id;
    }

    //<------ Getter and Setters for Above Variables ------>

    public String getFood(String type) {
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
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
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
