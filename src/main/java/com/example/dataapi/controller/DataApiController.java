package com.example.dataapi.controller;

import com.example.dataapi.jpa.pets;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping
public interface DataApiController {

    @ApiOperation(value = "Find Pets by ID", nickname = "findById")
    @ApiResponses(value = {
            @ApiResponse(code = 200, responseContainer= "Optional",response = pets.class, message = "")
    })
    @GetMapping(path = "/findById/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<Optional<pets>> findById(@PathVariable("id") Integer id){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Find Pets by Name", nickname = "findByName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, responseContainer= "List",response = pets.class, message = "")
    })
    @GetMapping(path = "/myPetName/{name}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<List<pets>> getByName(@PathVariable("name") String name){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Save pets", nickname = "savePets")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @PostMapping(path = "/savePet",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<Void> savePet(@RequestBody pets pet){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Remove pets", nickname = "removePets")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @DeleteMapping(path = "/removePet",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<Void> deletePet(@RequestBody pets pet){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    @ApiOperation(value = "Edit Pets", nickname = "findByName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "")
    })
    @PutMapping(path = "/patchPet/{id}",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    default ResponseEntity<Void> patchPet(@PathVariable("id") Integer id,@RequestBody pets pets){
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }
}
