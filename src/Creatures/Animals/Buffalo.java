package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Buffalo extends Herbivores {
    public Buffalo() {
        this.weight = 700;
        this.maxPopulation = 10;
        this.speed = 3;
        this.dailyFoodAllowance = 100;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.BUFFALO);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC03";
    }
}
