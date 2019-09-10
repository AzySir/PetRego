package com.petrego.PetRego.controller;

import com.petrego.PetRego.exception.ResourceNotFoundException;
import com.petrego.PetRego.model.Pet;
import com.petrego.PetRego.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Scope: This class handles the Pet API
 *
 * @version 1.0
 * @author Adam Sir
 * @date 10th September 2019
 *
 */
@RestController //Declare RestController
@RequestMapping("/api") //Map the main URI to /api
public class PetController {

    @Autowired
    PetRepository petRepository;

    //<------ API VERSION 1.0 ----------- >

    // Get ALL pets

    @GetMapping("/v1/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    //Get Pet By Id
    @GetMapping("/v1/pet/{id}")
    public Pet getPetById(@PathVariable(value = "id") Long pet_id) {
        return petRepository.findById(pet_id).orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", pet_id));
    }

//    Get Pet(s) By Name
    @GetMapping("/v1/pet/name/{petname}")
    public List<Pet> getPetByName(@PathVariable(value = "petname") String pet_name) {
        List<Pet> petList = petRepository.findByName(pet_name);
        List<Pet> filterByNameList = new ArrayList<Pet>();
        for (Pet p : petList) {
            if (p.getPetName() == pet_name) {
                filterByNameList.add(p);
            }
        }
        return filterByNameList;
    }

    //Get Pet By Owner Id - This is returned as a list because the owner can have many pets
    @GetMapping("/v1/pet/owner/{ownerid}")
    public List<Pet> getPetByOwnerId(@PathVariable(value = "ownerid") Long owner_id) {
        return petRepository.findByOwnerId(owner_id);
    }

//    @PostMapping(path = "/v1/pet", consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE} )
    @PostMapping(path = "/v1/pet", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity addPet(@RequestBody Pet petDetails) {
        Pet p = new Pet();
        p.setPetName(petDetails.getPetName());
        p.setPetType(petDetails.getPetType());
        p.setAge(petDetails.getAge());
        p.setOwnerId(petDetails.getOwnerId());
        p.setPetFood(p.getFoodType(petDetails.getPetType()));
        petRepository.save(p);
        return ResponseEntity.ok().build();
    }

    //<--------- END OF API V1.0 ------------>


    // <----- API VERSION 2.0 - NEW --------->

    //Multiple API Version handling
    @GetMapping("/v2/pet/name/{name}")
    public List<Pet> getPetByNameNew(@PathVariable(value = "name") String pet_name) {
        return petRepository.findByNameNew(pet_name);
    }

    //Multiple API Version handling
    @GetMapping("/v2/pet/owner/{ownerid}")
    public List<Pet> getPetByOwnerIdNew(@PathVariable(value = "ownerid") Long owner_id) {
        return petRepository.findByOwnerIdNew(owner_id);
    }

    //<!---- END OF API V2.0 ----------- >

}
