// @ Hoja de trabajo 6
// @ File Name : MapFactory.java
// @ Date : 08/03/2025
// @ Author : Alejandro Manuel Jerez Melgar 24678

package com.api;
import java.util.Map;

/**
 * Interface for creating different types of maps.
 */
interface MapFactory {
    /**
     * Creates a new map instance.
     * @return a new map instance.
     */
    Map<String, Pokemon> createMap();
}