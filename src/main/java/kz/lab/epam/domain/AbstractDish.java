package kz.lab.epam.domain;


public abstract class AbstractDish {
    private Meat meat;
    private Spice spice;
    private Vegetable vegetable;

    public void setMeat(Meat meat) {
        this.meat = meat;
    }

    public Meat getMeat() {
        return meat;
    }

    public void setSpice(Spice spice) {
        this.spice = spice;
    }

    public Spice getSpice() {
        return spice;
    }

    public void setVegetable(Vegetable vegetable) {
        this.vegetable = vegetable;
    }

    public Vegetable getVegetable() {
        return vegetable;
    }

}

