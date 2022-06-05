package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Goat extends Herbivores {
    public Goat() {
        this.weight = 60;
        this.maxPopulation = 140;
        this.speed = 3;
        this.dailyFoodAllowance = 10;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.GOAT);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC10";
    }
}
