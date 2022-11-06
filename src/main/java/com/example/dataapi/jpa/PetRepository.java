package com.example.dataapi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<pets, Long> {

    List<pets> findByName(String name);

    @Query("SELECT p FROM pets p WHERE name = :name and gender = :gender and age = :age and animal = :animal")
    List<pets> findPetWithoutId(@Param("name") String name, @Param("gender")String gender, @Param("age")int age, @Param("animal") String animal);

}
