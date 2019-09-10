package com.petrego.PetRego.repository;

import com.petrego.PetRego.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
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
@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {
//        @Repository
//        public interface AuctionRepository extends CrudRepository<Auction, String>{
//
//                @Query("from Auction a join a.category c where c.name=:categoryName")
//                public Iterable<Auction> findByCategory(String categoryName);
//
//        }
//        NOT SURE IF THIS WILL WORK - Requires testing and more indepth analysis
//        @Query(value = "SELECT ID, PET_NAME, PET_TYPE, FOOD FROM PETS WHERE PET_NAME = ?1", nativeQuery = true)
        @Query(value = "SELECT p.id, p.pet_name, p.pet_type, p.pet_food FROM Pet p WHERE p.pet_name = ?1")
        List<Pet> findByName(String search_name);
//      @Query("SELECT p.ID, p.PET_NAME, p.PET_TYPE, p.FOOD FROM PETS p WHERE p.PET_NAME = ?1")


        //V2 Api Query - To Get ALL Pet Columns in the Database by Pet_Name via Custom Query(which includes enhancements)
        @Query(value = "SELECT * FROM PETS WHERE PET_NAME = ?1", nativeQuery = true)
        List<Pet> findByNameNew(String search_name);

        //V1 API - Query to find selected columns by Owner Id (display legacy version)
        @Query(value = "SELECT ID, PET_NAME, PET_TYPE, FOOD FROM PETS WHERE OWNER_ID = ?1", nativeQuery = true)
        List<Pet> findByOwnerId(Long owner_id);

        //V2 API - Query to find by Owner Id (display enhancement to gather more information)
        @Query(value = "SELECT * FROM PETS WHERE OWNER_ID = ?1", nativeQuery = true)
        List<Pet> findByOwnerIdNew(Long owner_id);
}
