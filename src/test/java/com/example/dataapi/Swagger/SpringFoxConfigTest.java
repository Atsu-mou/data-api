package com.example.dataapi.Swagger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import springfox.documentation.spring.web.plugins.Docket;

class SpringFoxConfigTest {
    /**
     * Method under test: {@link SpringFoxConfig#api()}
     */
    @Test
    void testApi() {

        Docket actualApiResult = (new SpringFoxConfig()).api();
        assertTrue(actualApiResult.isEnabled());
        assertEquals("default", actualApiResult.getGroupName());
    }
}

