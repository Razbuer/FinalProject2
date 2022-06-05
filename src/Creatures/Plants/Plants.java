package Creatures.Plants;

import Creatures.NatureObject;
import Creatures.Eatable;

public abstract class Plants extends NatureObject implements Eatable {
    public Plants() {
        this.weight = 1;
        this.maxPopulation = 200;
    }

}
