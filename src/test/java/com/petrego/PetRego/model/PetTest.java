package com.petrego.PetRego.model;

import com.petrego.PetRego.repository.PetRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class PetTest {

    Pet bucket;


    @BeforeAll
    public void SetUp() {
        bucket = new Pet("Bucket", "Dog", "Bones", 15, 777L);
    }

    @Test
    public void getPetName() {
        assertEquals(bucket.getPetName(), "Bucket");
    }

    @Test
    public void getPetType() {
        assertEquals(bucket.getPetType(), "Dog");
    }

    @Test
    public void getPetFood() {
        assertEquals(bucket.getPetFood(), "Bones");
    }

    @Test
    public void getAge() {
        assertEquals(bucket.getAge(), 15);
    }

    @Test
    public void getOwnerId() {
        assertEquals(bucket.getOwnerId(), Long.valueOf(777L));
    }
}