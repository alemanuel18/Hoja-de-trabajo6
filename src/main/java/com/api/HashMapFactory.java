// @ Hoja de trabajo 6
// @ File Name : HashMapFactory.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;
import java.util.HashMap;
import java.util.Map;

/**
 * Factory class to create a HashMap instance.
 */
class HashMapFactory implements MapFactory {
    /**
     * Creates a new HashMap instance.
     * @return a new HashMap instance.
     */
    @Override
    public Map<String, Pokemon> createMap() {
        return new HashMap<>();
    }
}