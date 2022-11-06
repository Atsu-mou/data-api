package com.example.dataapi.controller;

import com.example.dataapi.jpa.pets;
import com.example.dataapi.service.PetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
public class DataApiControllerImpl implements DataApiController {

    @Autowired
    public DataApiControllerImpl(PetService petService) {
        this.petService = petService;
    }

    final PetService petService;

    @Override
    public ResponseEntity<Optional<pets>> findById(Integer idValue) {
        return petService.findById(idValue);
    }

    @Override
    public ResponseEntity<Void> deletePet(pets pet) {
        return petService.deletePet(pet);
    }

    @Override
    public ResponseEntity<Void> patchPet(Integer id, pets pets) {
        return petService.patchPet(id, pets);
    }

    @Override
    public ResponseEntity<List<pets>> getByName(String petName){
       return petService.getByName(petName);
    }

    @Override
    public ResponseEntity<Void> savePet(pets pet){
        petService.savePet(pet);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
