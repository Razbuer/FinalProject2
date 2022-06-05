package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Hog extends Herbivores {
    public Hog() {
        this.weight = 400;
        this.maxPopulation = 50;
        this.speed = 2;
        this.dailyFoodAllowance = 50;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.HOG);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC2E";
    }
}
