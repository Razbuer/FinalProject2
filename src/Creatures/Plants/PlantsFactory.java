package Creatures.Plants;

public class PlantsFactory {
    public static Plants getPlant(PlantsType plantsType) {
        return switch(plantsType) {
            case GRASS -> new Grass();
            case BERRIES -> new Berries();
        };
    }
}
