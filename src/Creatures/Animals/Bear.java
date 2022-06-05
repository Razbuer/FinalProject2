package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Bear extends Predator {
    public Bear() {
        this.weight = 500;
        this.maxPopulation = 5;
        this.speed = 2;
        this.dailyFoodAllowance = 80;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.BEAR);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC3B";
    }
}
