package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Fox extends Predator {
    public Fox() {
        this.weight = 8;
        this.maxPopulation = 30;
        this.speed = 2;
        this.dailyFoodAllowance = 2;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.FOX);
    }

    @Override
    public String getAvatar() {
        return "\uD83E\uDD8A";
    }
}
