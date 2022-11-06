package com.example.dataapi.service;

import com.example.dataapi.jpa.pets;
import com.example.dataapi.jpa.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PetServiceImpl implements PetService {

    @Autowired
    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    private final PetRepository petRepository;

    @Override
    public ResponseEntity<Optional<pets>> findById(Integer idValue) {
        if (petRepository.existsById(idValue.longValue())){
            Optional<pets> pet = petRepository.findById(idValue.longValue());
            return new ResponseEntity<>(pet, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Void> deletePet(pets pets) {
        List<pets> petList = petRepository.findPetWithoutId(pets.getName(), pets.getGender(), pets.getAge(), pets.getAnimal());
        if (petList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        petList.forEach(petRepository::delete);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<Void> patchPet(Integer id, pets pets) {
        pets petFromDB = petRepository.getOne(id.longValue());

        if (pets.getAge() != null){
            petFromDB.setAge(pets.getAge());
        }
        if(pets.getName() != null){
            petFromDB.setName(pets.getName());
        }
        if (pets.getAnimal() != null){
            petFromDB.setAnimal(pets.getAnimal());
        }
        if(pets.getGender() != null){
            petFromDB.setGender(pets.getGender());
        }
        petRepository.save(petFromDB);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Override
    public ResponseEntity<List<pets>> getByName(String petName) {
        List<pets> petList = new ArrayList<>(petRepository.findByName(petName));
        return new ResponseEntity<>(petList, HttpStatus.CREATED);
    }

    @Override
    public void savePet(pets pet) {
        petRepository.save(pet);
    }

    @Override
    public List<pets> getAllPets() {
        return petRepository.findAll();
    }
}
