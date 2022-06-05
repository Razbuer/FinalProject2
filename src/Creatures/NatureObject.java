package Creatures;

public abstract class NatureObject {
    protected float weight;
    protected int maxPopulation;

    public float getWeight() {
        return weight;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public abstract String getAvatar();
}
