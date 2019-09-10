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






}
