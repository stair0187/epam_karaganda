package kz.lab.epam.domain;

public class FirstDish extends AbstractDish {
    private Water water;
    public void setWater (Water water) {
        this.water = water;
    }
    public Water getWater () {
        return water;
    }
}
