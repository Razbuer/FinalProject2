package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Horse extends Herbivores {
    public Horse() {
        this.weight = 400;
        this.maxPopulation = 20;
        this.speed = 4;
        this.dailyFoodAllowance = 60;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.HORSE);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC0E";
    }
}
