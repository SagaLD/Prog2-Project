package Exempelkoder;

import java.util.Objects;

/**
 * Används som en nod i en graf
 */
public class CityExample {
    private final String name;

    public CityExample(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean equals(Object cityToCompare) {
        if (cityToCompare instanceof CityExample city) {
            return name.equals(city.name);
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(name);
    }

    public String toString() {
        return name;
    }
}
