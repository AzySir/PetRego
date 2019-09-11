package com.petrego.PetRego.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OwnerTest {
    Owner adam;

    @BeforeEach
    public void Setup() {
        adam = new Owner("Adam", "Ramanaskus", "04/03/1992", "adam.r@business.com", "0412333444", "Dog");
    }

    @Test
    @DisplayName("Owner First Name Test")
    public void getFirstName() {
        assertEquals(adam.getFirstName(),"Adam");
    }

    @Test
    @DisplayName("Owner Last Name Test")
    public void getLastName() {
        assertEquals(adam.getLastName(),"Ramanaskus");
    }

    @Test
    @DisplayName("Owner Date Of Birth Test")
    public void getDob() {
        assertEquals(adam.getDob(),"04/03/1992");
    }

    @Test
    @DisplayName("Owner Email Test")
    public void getEmail() {
        assertEquals(adam.getEmail(),"adam.r@business.com");
    }

    @Test
    @DisplayName("Owner Phone Number Test")
    public void getPhoneNumber() {
        assertEquals(adam.getPhoneNumber(),"0412333444");
    }

    @Test
    @DisplayName("Owner Pet Names Test")
    public void getPets() {
        assertEquals(adam.getPets(),"Dog");
    }
}