package Creatures.Animals;

import Creatures.NatureFactory;
import Creatures.NatureObject;
import Creatures.NatureType;

public class Mouse extends Herbivores {
    public Mouse() {
        this.weight = 0.05f;
        this.maxPopulation = 500;
        this.speed = 1;
        this.dailyFoodAllowance = 0.01f;
    }

    @Override
    public NatureObject reproduction() {
        return NatureFactory.getAnimal(NatureType.MOUSE);
    }

    @Override
    public String getAvatar() {
        return "\uD83D\uDC01";
    }
}
