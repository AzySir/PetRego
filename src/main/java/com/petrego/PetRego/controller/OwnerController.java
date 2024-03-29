package com.petrego.PetRego.controller;

import com.petrego.PetRego.exception.ResourceNotFoundException;
import com.petrego.PetRego.model.Owner;
import com.petrego.PetRego.model.Pet;
import com.petrego.PetRego.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Scope: This is the API Controller for the Owner Class
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

    // Get Owner pets
    @GetMapping("/v1/owners")
    public List<Owner> getAllPets() {
        return ownerRepository.findAll();
    }


    //Get Owner By Id
    @GetMapping("/v1/owner/{id}")
    public Owner getPetById(@PathVariable(value = "id") Long owner_id) {
        return ownerRepository.findById(owner_id).orElseThrow(() -> new ResourceNotFoundException("Owner", "Id", owner_id));
    }

    //Get Owner By Id
    @GetMapping("/v2/owner/name/{name}")
    public List<Owner> findByNameNew(@PathVariable(value = "name") String search_name) {
        return ownerRepository.findByNameNew(search_name);
    }

    //Get Owner By Name
    @GetMapping("/v1/owner/name/{name}")
    public List<Owner> getOwnerByName(@PathVariable(value = "name") String search_name) {
        return ownerRepository.findByName(search_name);
    }

    //Get Pet By Owner Id - This is returned as a list because the owner can have many  pets
    @GetMapping("/v1/owner/pets/{petname}")
    public List<Owner> getOwnerByPetName(@PathVariable(value = "petname") String pet_name) {
        return ownerRepository.findByPets(pet_name);
    }

    //Add Owner via Post (JSON Request)
    @PutMapping(path = "/v1/owner", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addOwner(@RequestBody Owner ownerDetails) {
        //Create the object from the JSON Post Request
        System.out.println(ownerDetails);
        Owner o = new Owner(ownerDetails.getFirstName(), ownerDetails.getLastName(), ownerDetails.getDob(),
                ownerDetails.getEmail(), ownerDetails.getPhoneNumber(), ownerDetails.getPets());
        ownerRepository.save(o); //Inject into Database via JPA
        return new ResponseEntity<>("Successfully added Single", HttpStatus.OK);
    }

    //Add Owner via Post (JSON Request)
    @PostMapping(path = "/v1/owner", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addOwner(@RequestBody Owner[] ownerDetails) {
            for (Owner o : ownerDetails) {
                Owner owner = new Owner(o.getFirstName(), o.getLastName(), o.getDob(),
                        o.getEmail(), o.getPhoneNumber(), o.getPets());
                ownerRepository.save(owner);
            }
        return new ResponseEntity<>("Successfully added Batch!", HttpStatus.OK);
    }
}
