package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Wolf extends Predator {
    public Wolf() {
        this.weight = 50;
        this.maxPopulation = 30;
        this.speed = 3;
        this.dailyFoodAllowance = 8;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.WOLF);
    }


    @Override
    public String getAvatar() {
        return "\uD83D\uDC3A";
    }
}
