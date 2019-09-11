package com.petrego.PetRego.model;

import com.petrego.PetRego.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Pet Object Test")
public class PetTest {

    Pet bucket;


    @BeforeEach
    public void SetUp() {
        bucket = new Pet("Bucket", "Dog", "Bones", 15, 777L);
    }

    @Test
    @DisplayName("Pet Name Test")
    public void getPetName() {
        assertEquals(bucket.getPetName(), "Bucket");
    }

    @Test
    @DisplayName("Pet Type Test")
    public void getPetType() {
        assertEquals(bucket.getPetType(), "Dog");
    }

    @Test
    @DisplayName("Pet Food Test")
    public void getPetFood() {
        assertEquals(bucket.getPetFood(), "Bones");
    }

    @Test
    @DisplayName("Pet Age Test")
    public void getAge() {
        assertEquals(bucket.getAge(), 15);
    }

    @Test
    @DisplayName("Pet Owner Id Test")
    public void getOwnerId() {
        assertEquals(bucket.getOwnerId(), Long.valueOf(777L));
    }
}