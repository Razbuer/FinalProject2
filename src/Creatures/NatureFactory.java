package Creatures;

import Creatures.Animals.*;
import Creatures.Plants.*;

public class NatureFactory {
    public static NatureObject getAnimal(NatureType natureType) {
        return switch(natureType) {
            case WOLF -> new Wolf();
            case SNAKE -> new Snake();
            case FOX -> new Fox();
            case BEAR -> new Bear();
            case EAGLE -> new Eagle();
            case HORSE -> new Horse();
            case DEER -> new Deer();
            case RABBIT -> new Rabbit();
            case BUFFALO -> new Buffalo();
            case GOAT -> new Goat();
            case SHEEP -> new Sheep();
            case MOUSE -> new Mouse();
            case HOG -> new Hog();
            case DUCK -> new Duck();
            case CATERPILLAR -> new Caterpillar();
            case GRASS -> new Grass();
            case BERRIES -> new Berries();
        };
    }
}
