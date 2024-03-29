package com.petrego.PetRego.controller;

import com.petrego.PetRego.exception.ResourceNotFoundException;
import com.petrego.PetRego.model.Pet;
import com.petrego.PetRego.repository.PetRepository;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    // <!------------- GET -------------->
    // Get ALL pets
    @GetMapping("/v1/pets")
    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    //Get Pet By Id
    @GetMapping("/v1/pet/{id}")
    public Pet getPetById(@PathVariable(value = "id") Long petId) {
        return petRepository.findById(petId).orElseThrow(() -> new ResourceNotFoundException("Pet", "Id", petId));
    }

    //Get Pet(s) By Name
    @GetMapping("/v1/pet/name/{petname}")
    public List<Pet> getPetByName(@PathVariable(value = "petname") String petName) {
        return petRepository.findByName(petName); //Retrieve SQL Query where the pet_name = value passed in API
//        return petList;
    }

    //Get Pet By Owner Id - This is returned as a    list because the owner can have many pets
    @GetMapping("/v1/pet/owner/{ownerid}")
    public List<Pet> getPetByOwnerId(@PathVariable(value = "ownerid") Long ownerId) {
        List<Pet> petList = petRepository.findByOwnerId(ownerId);; //Retrieve SQL Query where the pet_name = value passed in API
        List<Pet> filterByOwnerList = new ArrayList<Pet>(); //Declare a filtered list
        //Loop through the unfiltered list and if the unfiltered list has the name then add it to the filter list
        for (Pet p : petList) {
            if (p.getOwnerId().equals(ownerId)) {
                filterByOwnerList.add(p);
            }
        }
        return filterByOwnerList;
    }


    //<!---------- PUT / POST ---------------->
    //PUT - Single Pet
    @PutMapping(path = "/v1/pet", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addPet(@RequestBody Pet petDetails) {
        Pet p = new Pet(petDetails.getPetName(), petDetails.getPetType(), petDetails.getFoodType(petDetails.getPetType()), petDetails.getAge(), petDetails.getOwnerId());
        petRepository.save(p);
        return new ResponseEntity<>("Successfully added Pet", HttpStatus.OK);
    }

    //POST - Batch of Pets (JSON Array)
    @PostMapping(path = "/v1/pet", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> addPet(@RequestBody Pet[] petDetails) {
        for (Pet p : petDetails) {
            Pet pet = new Pet(p.getPetName(), p.getPetType(), p.getFoodType(p.getPetType()), p.getAge(), p.getOwnerId());
            petRepository.save(pet);
        }
        return new ResponseEntity<>("Successfully added Pet", HttpStatus.OK);
    }

    //<--------- END OF API V1.0 ------------>


    // <----- API VERSION 2.0 - NEW --------->

    //Multiple API Version handling
    @GetMapping("/v2/pet/name/{name}")
    public List<Pet> getPetByNameNew(@PathVariable(value = "name") String petName) {
        return petRepository.findByNameNew(petName);
    }

    //Multiple API Version handling
    @GetMapping("/v2/pet/owner/{ownerid}")
    public List<Pet> getPetByOwnerIdNew(@PathVariable(value = "ownerid") Long ownerId) {
        return petRepository.findByOwnerId(ownerId);
    }

    //<!---- END OF API V2.0 ----------- >

}
