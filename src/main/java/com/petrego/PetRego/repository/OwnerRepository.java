package com.petrego.PetRego.repository;

import com.petrego.PetRego.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    
}
