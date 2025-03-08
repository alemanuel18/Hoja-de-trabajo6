// @ Hoja de trabajo 6
// @ File Name : TreeMapFactoryTest.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;

import org.junit.jupiter.api.Test;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;


class TreeMapFactoryTest {
    @Test
    void testCreateMap() {
        MapFactory factory = new TreeMapFactory();
        Map<String, Pokemon> map = factory.createMap();
        assertNotNull(map);
        assertTrue(map.isEmpty());
    }
}
