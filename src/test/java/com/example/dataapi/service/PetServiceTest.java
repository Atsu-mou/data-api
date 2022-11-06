package com.example.dataapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dataapi.jpa.PetRepository;
import com.example.dataapi.jpa.pets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class PetServiceTest {
    /**
     * Method under test: {@link PetService#findById(Integer)}
     */
    @Test
    void testFindById() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        PetRepository petRepository = mock(PetRepository.class);
        when(petRepository.findById(any())).thenReturn(Optional.of(pets));
        when(petRepository.existsById(any())).thenReturn(true);
        ResponseEntity<Optional<pets>> actualFindByIdResult = (new PetServiceImpl(petRepository)).findById(1);
        assertTrue(Objects.requireNonNull(actualFindByIdResult.getBody()).isPresent());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindByIdResult.getStatusCode());
        verify(petRepository).existsById(any());
        verify(petRepository).findById(any());
    }

    /**
     * Method under test: {@link PetService#findById(Integer)}
     */
    @Test
    void testFindById2() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        PetRepository petRepository = mock(PetRepository.class);
        when(petRepository.findById(any())).thenReturn(Optional.of(pets));
        when(petRepository.existsById(any())).thenReturn(false);
        ResponseEntity<Optional<pets>> actualFindByIdResult = (new PetServiceImpl(petRepository)).findById(1);
        assertNull(actualFindByIdResult.getBody());
        assertEquals(HttpStatus.NOT_FOUND, actualFindByIdResult.getStatusCode());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
        verify(petRepository).existsById(any());
    }

    /**
     * Method under test: {@link PetService#deletePet(pets)}
     */
    @Test
    void testDeletePet() {
        PetRepository petRepository = mock(PetRepository.class);
        when(petRepository.findPetWithoutId(any(), any(), anyInt(), any()))
                .thenReturn(new ArrayList<>());
        PetServiceImpl petServiceImpl = new PetServiceImpl(petRepository);

        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        ResponseEntity<Void> actualDeletePetResult = petServiceImpl.deletePet(pets);
        assertNull(actualDeletePetResult.getBody());
        assertEquals(HttpStatus.NOT_FOUND, actualDeletePetResult.getStatusCode());
        assertTrue(actualDeletePetResult.getHeaders().isEmpty());
        verify(petRepository).findPetWithoutId(any(), any(), anyInt(), any());
    }

    /**
     * Method under test: {@link PetService#patchPet(Integer, pets)}
     */
    @Test
    void testPatchPet() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        PetRepository petRepository = mock(PetRepository.class);
        when(petRepository.save(any())).thenReturn(pets1);
        when(petRepository.getOne(any())).thenReturn(pets);
        PetServiceImpl petServiceImpl = new PetServiceImpl(petRepository);

        pets pets2 = new pets();
        pets2.setAge(1);
        pets2.setAnimal("Animal");
        pets2.setGender("Gender");
        pets2.setId(123L);
        pets2.setName("Bella");
        ResponseEntity<Void> actualPatchPetResult = petServiceImpl.patchPet(1, pets2);
        assertNull(actualPatchPetResult.getBody());
        assertEquals(HttpStatus.ACCEPTED, actualPatchPetResult.getStatusCode());
        assertTrue(actualPatchPetResult.getHeaders().isEmpty());
        verify(petRepository).getOne(any());
        verify(petRepository).save(any());
    }

    /**
     * Method under test: {@link PetService#getByName(String)}
     */
    @Test
    void testGetByName() {
        PetRepository petRepository = mock(PetRepository.class);
        ArrayList<pets> petsList = new ArrayList<>();
        when(petRepository.findByName(any())).thenReturn(petsList);
        ResponseEntity<List<pets>> actualByName = (new PetServiceImpl(petRepository)).getByName("Bella");
        List<pets> body = actualByName.getBody();
        assertEquals(petsList, body);
        assertTrue(Objects.requireNonNull(body).isEmpty());
        assertEquals(HttpStatus.CREATED, actualByName.getStatusCode());
        assertTrue(actualByName.getHeaders().isEmpty());
        verify(petRepository).findByName(any());
    }
}

