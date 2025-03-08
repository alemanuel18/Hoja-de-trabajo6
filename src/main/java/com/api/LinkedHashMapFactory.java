// @ Hoja de trabajo 6
// @ File Name : LinkedHashMapFactory.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Factory class to create a LinkedHashMap instance.
 */
class LinkedHashMapFactory implements MapFactory {
    /**
     * Creates a new LinkedHashMap instance.
     * @return a new LinkedHashMap instance.
     */
    @Override
    public Map<String, Pokemon> createMap() {
        return new LinkedHashMap<>();
    }
}
