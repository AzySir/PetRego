package com.petrego.PetRego.controller;

import com.petrego.PetRego.exception.ResourceNotFoundException;
import com.petrego.PetRego.model.Owner;
import com.petrego.PetRego.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Scope: This is the API Controller for the Owner Class
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */

@RestController
@RequestMapping("/api")
public class OwnerController {

    @Autowired
    OwnerRepository ownerRepository;

    //<------ API VERSION 1.0 ----------- >

    // Get ALL pets
    @GetMapping("/v1/owners")
    public List<Owner> getAllPets() {
        return ownerRepository.findAll();
    }

    //Get Pet By Id
    @GetMapping("/v1/owner/{id}")
    public Owner getPetById(@PathVariable(value = "id") Long owner_id) {
        return ownerRepository.findById(owner_id).orElseThrow(() -> new ResourceNotFoundException("Owner", "Id", owner_id));
    }

//    //Get Pet(s) By Name
//    @GetMapping("/v1/owner/name/{name}")
//    public List<Owner> getOwnerByName(@PathVariable(value = "name") String search_name) {
//        return ownerRepository.findByName(search_name);
//    }
//
//    //Get Pet By Owner Id - This is returned as a list because the owner can have many pets
//    @GetMapping("/v1/pet/owner/{ownerid}")
//    public List<Pet> getPetByOwnerId(@PathVariable(value = "ownerid") Long owner_id) {
//        return ownerRepository.findByOwnerId(owner_id);
//    }
//
//    //<--------- END OF API V1.0 ------------>
//
//
//    // <----- API VERSION 2.0 - NEW --------->
//
//    //Multiple API Version handling
//    @GetMapping("/v2/pet/name/{name}")
//    public List<Pet> getPetByNameNew(@PathVariable(value = "name") String pet_name) {
//        return ownerRepository.findByNameNew(pet_name);
//    }
//
//    //Multiple API Version handling
//    @GetMapping("/v2/pet/owner/{ownerid}")
//    public List<Pet> getPetByOwnerIdNew(@PathVariable(value = "ownerid") Long owner_id) {
//        return ownerRepository.findByOwnerIdNew(owner_id);
//    }
}
