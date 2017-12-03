package kz.lab.epam.domain;

public class Ingredient {
    private int cookTime;
    private int amount;
    private PutOrder putOrder;

    public void setCookTime(int value) {
        cookTime = value;
    }

    public int getCookTime() {
        return cookTime;

    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setPutOrder(PutOrder putOrder) {
        this.putOrder = putOrder;
    }

    public PutOrder getPutOrder() {
        return putOrder;
    }

    public Ingredient() {
    }


    public Ingredient(int cookTime) {
        this.cookTime = cookTime;
    }


}



