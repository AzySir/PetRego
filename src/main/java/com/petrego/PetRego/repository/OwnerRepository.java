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

    //NOT SURE IF THIS WILL WORK - Requires testing and more indepth analysis
    @Query(value = "SELECT o.id, o.first_name, o.last_name, o.dob, o.email, o.phone_number, o.pet FROM Owner o WHERE first_name = ?1 OR last_name = ?1")
    List<Owner> findByName(String search_name);


}
