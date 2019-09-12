package com.petrego.PetRego.repository;

import com.petrego.PetRego.model.Owner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Scope: This interface handles custom JPA Queries accesed via Controllers for Owner
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */

public interface OwnerRepository extends JpaRepository<Owner, Long> {

    @Query(value = "SELECT NEW Owner(o.firstName, o.lastName) FROM Owner o WHERE firstName = ?1 OR lastName = ?1")
    List<Owner> findByNameNew(String searchName);

    //Search By First_Name & Last_Name
    @Query(value = "SELECT * FROM Owners WHERE first_name = ?1 OR last_name = ?1", nativeQuery = true)
    List<Owner> findByName(String search_name);

    @Query(value = "SELECT * FROM Owners WHERE pets LIKE %?1%", nativeQuery = true)
    List<Owner> findByPets(String pets);


}
