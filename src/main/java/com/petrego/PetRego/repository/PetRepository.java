package com.petrego.PetRego.repository;

import com.petrego.PetRego.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;
import java.util.List;

/**
 * Scope: This interface handles custom JPA Queries accesed via Controllers
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

        //V1 Api Query - To Get ALL Pet Columns in the Database by Pet_Name via Custom Query(which includes enhancements)
        @Query(value = "SELECT NEW Pet(p.petName, p.petType, p.petFood) FROM Pet p WHERE p.petName = ?1")
        List<Pet> findByName(String search_name);

        //V2 Api Query - To Get ALL Pet Columns in the Database by Pet_Name via Custom Query(which includes enhancements)
        @Query(value = "SELECT p FROM Pet p WHERE p.petName = ?1")
        List<Pet> findByNameNew(String search_name);

        //Query to find selected columns  (display legacy version)
        @Query(value = "SELECT * FROM PETS WHERE OWNER_ID = ?1", nativeQuery = true)
        List<Pet> findByOwnerId(Long owner_id);
}
