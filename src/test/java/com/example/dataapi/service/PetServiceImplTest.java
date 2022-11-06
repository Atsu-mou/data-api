package com.example.dataapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
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
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PetServiceImpl.class})
@ExtendWith(SpringExtension.class)
class PetServiceImplTest {
    @MockBean
    private PetRepository petRepository;

    @Autowired
    private PetServiceImpl petServiceImpl;

    /**
     * Method under test: {@link PetServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        Optional<pets> ofResult = Optional.of(pets);
        when(petRepository.findById(any())).thenReturn(ofResult);
        when(petRepository.existsById(any())).thenReturn(true);
        ResponseEntity<Optional<pets>> actualFindByIdResult = petServiceImpl.findById(1);
        assertTrue(Objects.requireNonNull(actualFindByIdResult.getBody()).isPresent());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualFindByIdResult.getStatusCode());
        verify(petRepository).existsById(any());
        verify(petRepository).findById(any());
    }

    /**
     * Method under test: {@link PetServiceImpl#findById(Integer)}
     */
    @Test
    void testFindById2() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        Optional<pets> ofResult = Optional.of(pets);
        when(petRepository.findById(any())).thenReturn(ofResult);
        when(petRepository.existsById(any())).thenReturn(false);
        ResponseEntity<Optional<pets>> actualFindByIdResult = petServiceImpl.findById(1);
        assertNull(actualFindByIdResult.getBody());
        assertEquals(HttpStatus.NOT_FOUND, actualFindByIdResult.getStatusCode());
        assertTrue(actualFindByIdResult.getHeaders().isEmpty());
        verify(petRepository).existsById(any());
    }

    /**
     * Method under test: {@link PetServiceImpl#deletePet(pets)}
     */
    @Test
    void testDeletePet() {
        when(petRepository.findPetWithoutId(any(), any(), anyInt(), any()))
                .thenReturn(new ArrayList<>());

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
     * Method under test: {@link PetServiceImpl#deletePet(pets)}
     */
    @Test
    void testDeletePet2() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");

        ArrayList<pets> petsList = new ArrayList<>();
        petsList.add(pets);
        doNothing().when(petRepository).delete(any());
        when(petRepository.findPetWithoutId(any(), any(), anyInt(), any()))
                .thenReturn(petsList);

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        ResponseEntity<Void> actualDeletePetResult = petServiceImpl.deletePet(pets1);
        assertNull(actualDeletePetResult.getBody());
        assertEquals(HttpStatus.ACCEPTED, actualDeletePetResult.getStatusCode());
        assertTrue(actualDeletePetResult.getHeaders().isEmpty());
        verify(petRepository).findPetWithoutId(any(), any(), anyInt(), any());
        verify(petRepository).delete(any());
    }

    /**
     * Method under test: {@link PetServiceImpl#deletePet(pets)}
     */
    @Test
    void testDeletePet3() {
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

        ArrayList<pets> petsList = new ArrayList<>();
        petsList.add(pets1);
        petsList.add(pets);
        doNothing().when(petRepository).delete(any());
        when(petRepository.findPetWithoutId(any(), any(), anyInt(), any()))
                .thenReturn(petsList);

        pets pets2 = new pets();
        pets2.setAge(1);
        pets2.setAnimal("Animal");
        pets2.setGender("Gender");
        pets2.setId(123L);
        pets2.setName("Bella");
        ResponseEntity<Void> actualDeletePetResult = petServiceImpl.deletePet(pets2);
        assertNull(actualDeletePetResult.getBody());
        assertEquals(HttpStatus.ACCEPTED, actualDeletePetResult.getStatusCode());
        assertTrue(actualDeletePetResult.getHeaders().isEmpty());
        verify(petRepository).findPetWithoutId(any(), any(), anyInt(), any());
        verify(petRepository, atLeast(1)).delete(any());
    }

    /**
     * Method under test: {@link PetServiceImpl#deletePet(pets)}
     */
    @Test
    void testDeletePet4() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");

        ArrayList<pets> petsList = new ArrayList<>();
        petsList.add(pets);
        doNothing().when(petRepository).delete(any());
        when(petRepository.findPetWithoutId(any(), any(), anyInt(), any()))
                .thenReturn(petsList);
        pets pets1 = mock(pets.class);
        when(pets1.getAge()).thenReturn(1);
        when(pets1.getAnimal()).thenReturn("Animal");
        when(pets1.getGender()).thenReturn("Gender");
        when(pets1.getName()).thenReturn("Bella");
        doNothing().when(pets1).setAge(any());
        doNothing().when(pets1).setAnimal(any());
        doNothing().when(pets1).setGender(any());
        doNothing().when(pets1).setId(any());
        doNothing().when(pets1).setName(any());
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        ResponseEntity<Void> actualDeletePetResult = petServiceImpl.deletePet(pets1);
        assertNull(actualDeletePetResult.getBody());
        assertEquals(HttpStatus.ACCEPTED, actualDeletePetResult.getStatusCode());
        assertTrue(actualDeletePetResult.getHeaders().isEmpty());
        verify(petRepository).findPetWithoutId(any(), any(), anyInt(), any());
        verify(petRepository).delete(any());
        verify(pets1).getAge();
        verify(pets1).getAnimal();
        verify(pets1).getGender();
        verify(pets1).getName();
        verify(pets1).setAge(any());
        verify(pets1).setAnimal(any());
        verify(pets1).setGender(any());
        verify(pets1).setId(any());
        verify(pets1).setName(any());
    }

    /**
     * Method under test: {@link PetServiceImpl#patchPet(Integer, pets)}
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
        when(petRepository.save(any())).thenReturn(pets1);
        when(petRepository.getOne(any())).thenReturn(pets);

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
     * Method under test: {@link PetServiceImpl#patchPet(Integer, pets)}
     */
    @Test
    void testPatchPet2() {
        pets pets = mock(pets.class);
        doNothing().when(pets).setAge(any());
        doNothing().when(pets).setAnimal(any());
        doNothing().when(pets).setGender(any());
        doNothing().when(pets).setId(any());
        doNothing().when(pets).setName(any());
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
        when(petRepository.save(any())).thenReturn(pets1);
        when(petRepository.getOne(any())).thenReturn(pets);

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
        verify(pets, atLeast(1)).setAge(any());
        verify(pets, atLeast(1)).setAnimal(any());
        verify(pets, atLeast(1)).setGender(any());
        verify(pets).setId(any());
        verify(pets, atLeast(1)).setName(any());
    }

    /**
     * Method under test: {@link PetServiceImpl#getByName(String)}
     */
    @Test
    void testGetByName() {
        ArrayList<pets> petsList = new ArrayList<>();
        when(petRepository.findByName(any())).thenReturn(petsList);
        ResponseEntity<List<pets>> actualByName = petServiceImpl.getByName("Bella");
        List<pets> body = actualByName.getBody();
        assertEquals(petsList, body);
        assertTrue(Objects.requireNonNull(body).isEmpty());
        assertEquals(HttpStatus.CREATED, actualByName.getStatusCode());
        assertTrue(actualByName.getHeaders().isEmpty());
        verify(petRepository).findByName(any());
    }

    /**
     * Method under test: {@link PetServiceImpl#savePet(pets)}
     */
    @Test
    void testSavePet() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        when(petRepository.save(any())).thenReturn(pets);

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        petServiceImpl.savePet(pets1);
        verify(petRepository).save(any());
        assertEquals(1, pets1.getAge().intValue());
        assertEquals("Bella", pets1.getName());
        assertEquals(123L, pets1.getId().longValue());
        assertEquals("Gender", pets1.getGender());
        assertEquals("Animal", pets1.getAnimal());
    }

    /**
     * Method under test: {@link PetServiceImpl#getAllPets()}
     */
    @Test
    void testGetAllPets() {
        ArrayList<pets> petsList = new ArrayList<>();
        when(petRepository.findAll()).thenReturn(petsList);
        List<pets> actualAllPets = petServiceImpl.getAllPets();
        assertSame(petsList, actualAllPets);
        assertTrue(actualAllPets.isEmpty());
        verify(petRepository).findAll();
    }
}

