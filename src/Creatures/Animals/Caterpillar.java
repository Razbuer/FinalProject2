package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Caterpillar extends Herbivores {
    public Caterpillar() {
        this.weight = 0.01f;
        this.maxPopulation = 1000;
        this.speed = 0;
        this.dailyFoodAllowance = 0;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.CATERPILLAR);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC1B";
    }
}
