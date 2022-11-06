package com.example.dataapi.jpa;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class petsTest {
    /**
     * Method under test: {@link pets#canEqual(Object)}
     */
    @Test
    void testCanEqual() {
        assertFalse((new pets()).canEqual("Other"));
    }

    /**
     * Method under test: {@link pets#canEqual(Object)}
     */
    @Test
    void testCanEqual2() {
        pets pets = new pets();

        pets pets1 = new pets();
        pets1.setAge(3);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertTrue(pets.canEqual(pets1));
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#pets()}
     *   <li>{@link pets#setAge(Integer)}
     *   <li>{@link pets#setAnimal(String)}
     *   <li>{@link pets#setGender(String)}
     *   <li>{@link pets#setId(Long)}
     *   <li>{@link pets#setName(String)}
     *   <li>{@link pets#toString()}
     *   <li>{@link pets#getAge()}
     *   <li>{@link pets#getAnimal()}
     *   <li>{@link pets#getGender()}
     *   <li>{@link pets#getId()}
     *   <li>{@link pets#getName()}
     * </ul>
     */
    @Test
    void testConstructor() {
        pets actualPets = new pets();
        actualPets.setAge(1);
        actualPets.setAnimal("Animal");
        actualPets.setGender("Gender");
        actualPets.setId(123L);
        actualPets.setName("Bella");
        String actualToStringResult = actualPets.toString();
        assertEquals(1, actualPets.getAge().intValue());
        assertEquals("Animal", actualPets.getAnimal());
        assertEquals("Gender", actualPets.getGender());
        assertEquals(123L, actualPets.getId().longValue());
        assertEquals("Bella", actualPets.getName());
        assertEquals("pets(id=123, name=Bella, gender=Gender, age=1, animal=Animal)", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#pets(Long, String, String, Integer, String)}
     *   <li>{@link pets#setAge(Integer)}
     *   <li>{@link pets#setAnimal(String)}
     *   <li>{@link pets#setGender(String)}
     *   <li>{@link pets#setId(Long)}
     *   <li>{@link pets#setName(String)}
     *   <li>{@link pets#toString()}
     *   <li>{@link pets#getAge()}
     *   <li>{@link pets#getAnimal()}
     *   <li>{@link pets#getGender()}
     *   <li>{@link pets#getId()}
     *   <li>{@link pets#getName()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        pets actualPets = new pets(123L, "Bella", "Gender", 1, "Animal");
        actualPets.setAge(1);
        actualPets.setAnimal("Animal");
        actualPets.setGender("Gender");
        actualPets.setId(123L);
        actualPets.setName("Bella");
        String actualToStringResult = actualPets.toString();
        assertEquals(1, actualPets.getAge().intValue());
        assertEquals("Animal", actualPets.getAnimal());
        assertEquals("Gender", actualPets.getGender());
        assertEquals(123L, actualPets.getId().longValue());
        assertEquals("Bella", actualPets.getName());
        assertEquals("pets(id=123, name=Bella, gender=Gender, age=1, animal=Animal)", actualToStringResult);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        assertNotEquals(pets, null);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals2() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        assertNotEquals(pets, "Different type to pets");
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#equals(Object)}
     *   <li>{@link pets#hashCode()}
     * </ul>
     */
    @Test
    void testEquals3() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");
        assertEquals(pets, pets);
        int expectedHashCodeResult = pets.hashCode();
        assertEquals(expectedHashCodeResult, pets.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#equals(Object)}
     *   <li>{@link pets#hashCode()}
     * </ul>
     */
    @Test
    void testEquals4() {
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
        assertEquals(pets, pets1);
        int expectedHashCodeResult = pets.hashCode();
        assertEquals(expectedHashCodeResult, pets1.hashCode());
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals5() {
        pets pets = new pets();
        pets.setAge(3);
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
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals6() {
        pets pets = new pets();
        pets.setAge(null);
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
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals7() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Bella");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals8() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal(null);
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals9() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Bella");
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals10() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender(null);
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals11() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(1L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals12() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(null);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals13() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Gender");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Method under test: {@link pets#equals(Object)}
     */
    @Test
    void testEquals14() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName(null);

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertNotEquals(pets, pets1);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#equals(Object)}
     *   <li>{@link pets#hashCode()}
     * </ul>
     */
    @Test
    void testEquals15() {
        pets pets = new pets();
        pets.setAge(null);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(null);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertEquals(pets, pets1);
        int expectedHashCodeResult = pets.hashCode();
        assertEquals(expectedHashCodeResult, pets1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#equals(Object)}
     *   <li>{@link pets#hashCode()}
     * </ul>
     */
    @Test
    void testEquals16() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal(null);
        pets.setGender("Gender");
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal(null);
        pets1.setGender("Gender");
        pets1.setId(123L);
        pets1.setName("Bella");
        assertEquals(pets, pets1);
        int expectedHashCodeResult = pets.hashCode();
        assertEquals(expectedHashCodeResult, pets1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#equals(Object)}
     *   <li>{@link pets#hashCode()}
     * </ul>
     */
    @Test
    void testEquals17() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender(null);
        pets.setId(123L);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender(null);
        pets1.setId(123L);
        pets1.setName("Bella");
        assertEquals(pets, pets1);
        int expectedHashCodeResult = pets.hashCode();
        assertEquals(expectedHashCodeResult, pets1.hashCode());
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link pets#equals(Object)}
     *   <li>{@link pets#hashCode()}
     * </ul>
     */
    @Test
    void testEquals18() {
        pets pets = new pets();
        pets.setAge(1);
        pets.setAnimal("Animal");
        pets.setGender("Gender");
        pets.setId(null);
        pets.setName("Bella");

        pets pets1 = new pets();
        pets1.setAge(1);
        pets1.setAnimal("Animal");
        pets1.setGender("Gender");
        pets1.setId(null);
        pets1.setName("Bella");
        assertEquals(pets, pets1);
        int expectedHashCodeResult = pets.hashCode();
        assertEquals(expectedHashCodeResult, pets1.hashCode());
    }
}

