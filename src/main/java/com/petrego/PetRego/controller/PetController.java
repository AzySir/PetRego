package com.petrego.PetRego.controller;

import com.petrego.PetRego.model.Pet;
import com.petrego.PetRego.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PetController {


    //Get ALL pets
    @GetMapping("/v1/pets")

    //Get Pet By Id
    @GetMapping("/v1/pet/{id}")

    //Get Pet(s) By Name
    @GetMapping("/v1/pet/name/{name}")

    //Get Pet By Owner Id
    @GetMapping("/v1/pet/owner/{ownerid}")
    
    //Multiple API Version handling
    @GetMapping("/v2/pet/name/{name}")


}
