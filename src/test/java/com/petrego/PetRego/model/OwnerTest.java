package com.petrego.PetRego.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class OwnerTest {
    Owner adam;

    @BeforeEach
    public void Setup() {
        adam = new Owner("Adam", "Ramanaskus", "04/03/1992", "adam.r@business.com", "0412333444", "Dog");
    }

    @Test
    public void getFirstName() {
        assertEquals(adam.getFirstName(),"Adam");
    }

    @Test
    public void getLastName() {
        assertEquals(adam.getLastName(),"Ramanaskus");
    }

    @Test
    public void getDob() {
        assertEquals(adam.getDob(),"04/03/1992");
    }

    @Test
    public void getEmail() {
        assertEquals(adam.getEmail(),"adam.r@business.com");
    }

    @Test
    public void getPhoneNumber() {
        assertEquals(adam.getPhoneNumber(),"0412333444");
    }

    @Test
    public void getPets() {
        assertEquals(adam.getPets(),"Dog");
    }
}