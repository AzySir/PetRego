package com.petrego.PetRego.Pet;

import com.petrego.PetRego.model.Pet;
import com.petrego.PetRego.repository.PetRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static java.time.Duration.ofMillis;
import static java.time.Duration.ofMinutes;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PetTests {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PetRepository petRepository;

    @Test
    public void verifyOwnerIdAndAgeIsInt() {

        // given
//        public Pet(String pet_name, String type, String pet_food, int age, Long owner_id) {
        Pet bucket = new Pet("Bucket", "Dog", "Bones", 15, 777L);
        entityManager.persist(bucket);
        entityManager.flush();

        // when
        List<Pet> foundList = petRepository.findByName(bucket.getPetName());

        // then
        assertTrue( foundList.size() >= 1);

        for (Pet p : foundList) {
            assertTrue(p.getPetName().equals(bucket.getPetName()));
        }
    }

//    @Test
//    public void assertDataTypes() {
//        Pet bucket = new Pet("Bucket", "Dog", "Bones", 15, 777L);
////        assertAll("student", () -> assertEquals("Ramesh", student.getFirstName()),
////                () -> assertEquals("Fadatare", student.getLastName()));
//
//        assertAll() {"dataType",
//                () -> assertTrue(bucket.getPetType().getClass().getName(), String)
//
//        }
//    }
}
