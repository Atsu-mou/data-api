package com.example.dataapi.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.dataapi.jpa.pets;
import com.example.dataapi.service.PetService;

import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {DataApiControllerImpl.class})
@ExtendWith(SpringExtension.class)
class DataApiControllerImplTest {
    @Autowired
    private DataApiControllerImpl dataapiControllerImpl;

    @MockBean
    private PetService petService;

    /**
     * Method under test: {@link DataApiControllerImpl#findById(Integer)}
     */
    @Test
    void testFindById() {
        ResponseEntity<Optional<pets>> responseEntity = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(petService.findById(any())).thenReturn(responseEntity);
        assertSame(responseEntity, dataapiControllerImpl.findById(1));
        verify(petService).findById(any());
    }

    /**
     * Method under test: {@link DataApiControllerImpl#deletePet(pets)}
     */
    @Test
    void testDeletePet() {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(petService.deletePet(any())).thenReturn(responseEntity);

        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        assertSame(responseEntity, dataapiControllerImpl.deletePet(pets));
        verify(petService).deletePet(any());
    }

    /**
     * Method under test: {@link DataApiControllerImpl#patchPet(Integer, pets)}
     */
    @Test
    void testPatchPet() {
        ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(petService.patchPet(any(), any())).thenReturn(responseEntity);

        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        assertSame(responseEntity, dataapiControllerImpl.patchPet(1, pets));
        verify(petService).patchPet(any(), any());
    }

    /**
     * Method under test: {@link DataApiControllerImpl#getByName(String)}
     */
    @Test
    void testGetByName() {
        ResponseEntity<List<pets>> responseEntity = new ResponseEntity<>(HttpStatus.CONTINUE);
        when(petService.getByName(any())).thenReturn(responseEntity);
        assertSame(responseEntity, dataapiControllerImpl.getByName("Bella"));
        verify(petService).getByName(any());
    }

    /**
     * Method under test: {@link DataApiControllerImpl#savePet(pets)}
     */
    @Test
    void testSavePet() {
        doNothing().when(petService).savePet(any());

        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        ResponseEntity<Void> actualSavePetResult = dataapiControllerImpl.savePet(pets);
        assertNull(actualSavePetResult.getBody());
        assertEquals(HttpStatus.CREATED, actualSavePetResult.getStatusCode());
        assertTrue(actualSavePetResult.getHeaders().isEmpty());
        verify(petService).savePet(any());
    }
}

