package com.petrego.PetRego.repository;

import com.petrego.PetRego.model.Pet;
import com.sun.xml.internal.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Scope: This interface handles custom JPA Queries accesed via Controllers
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */

public interface PetRepository extends JpaRepository<Pet, Long> {

        //NOT SURE IF THIS WILL WORK - Requires testing and more indepth analysis
        @Query(value = "SELECT ID, PET_NAME, ANIMAL_TYPE, FOOD FROM PETS WHERE PET_NAME = ?1", nativeQuery = true)
        List<Pet> findByName(String search_name);

        //V2 Api Query - To Get ALL Pet Columns in the Database by Pet_Name via Custom Query(which includes enhancements)
        @Query(value = "SELECT * FROM PETS WHERE PET_NAME = ?1", nativeQuery = true)
        List<Pet> findByNameNew(String search_name);

        //V1 API - Query to find selected columns by Owner Id (display legacy version)
        @Query(value = "SELECT ID, PET_NAME, ANIMAL_TYPE, FOOD FROM PETS WHERE OWNER_ID = ?1", nativeQuery = true)
        List<Pet> findByOwnerId(Long owner_id);

        //V2 API - Query to find by Owner Id (display enhancement to gather more information)
        @Query(value = "SELECT * FROM PETS WHERE OWNER_ID = ?1", nativeQuery = true)
        List<Pet> findByOwnerIdNew(Long owner_id);
}
