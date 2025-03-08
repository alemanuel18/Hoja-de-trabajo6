// @ Hoja de trabajo 6
// @ File Name : LinkedHashMapFactoryTest.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class LinkedHashMapFactoryTest {
    @Test
    void testCreateMap() {
        MapFactory factory = new LinkedHashMapFactory();
        Map<String, Pokemon> map = factory.createMap();
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }
}
