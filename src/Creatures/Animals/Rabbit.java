package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Rabbit extends Herbivores {
    public Rabbit() {
        this.weight = 2;
        this.maxPopulation = 150;
        this.speed = 2;
        this.dailyFoodAllowance = 0.45f;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.RABBIT);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC07";
    }
}
