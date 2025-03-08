// @ Hoja de trabajo 6
// @ File Name : TreeMapFactory.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;
import java.util.Map;
import java.util.TreeMap;

/**
 * Factory class to create a TreeMap instance.
 */
class TreeMapFactory implements MapFactory {
    /**
     * Creates a new TreeMap instance.
     * @return a new TreeMap instance.
     */
    @Override
    public Map<String, Pokemon> createMap() {
        return new TreeMap<>();
    }
}