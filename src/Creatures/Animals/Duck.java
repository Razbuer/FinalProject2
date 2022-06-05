package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Duck extends Herbivores {
    public Duck() {
        this.weight = 1;
        this.maxPopulation = 200;
        this.speed = 4;
        this.dailyFoodAllowance = 0.15f;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.DUCK);
    }

    @Override
    public String getAvatar() {
        return "\uD83E\uDD86";
    }
}
