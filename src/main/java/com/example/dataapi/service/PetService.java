package com.example.dataapi.service;

import com.example.dataapi.jpa.pets;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface PetService {

    default ResponseEntity<Optional<pets>> findById(Integer id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Void> deletePet(pets pets){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<Void> patchPet(Integer id, pets pets){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    default ResponseEntity<List<pets>> getByName(String petName){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
    void savePet(pets people);
    List<pets> getAllPets();


}
