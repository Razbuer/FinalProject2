package util;

import Creatures.Animals.Animal;
import Creatures.Animals.Wolf;
import Creatures.NatureObject;
import Creatures.NatureType;

import java.util.Objects;

public class Pair {
    Class t;
    Class y;

    public Pair(Class t, Class y) {
        this.t = t;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(t, pair.t) && Objects.equals(y, pair.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(t, y);
    }
}