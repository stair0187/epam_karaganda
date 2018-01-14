package kz.lab.epam;

public class CartItem {

    private Long ID_cart;
    private Long ID_autopart;
    private Integer count;

    public Long getID_cart() {
        return ID_cart;
    }

    public void setID_cart(Long ID_cart) {
        this.ID_cart = ID_cart;
    }


    public Long getID_autopart() {
        return ID_autopart;
    }

    public void setID_autopart(Long ID_autopart) {
        this.ID_autopart = ID_autopart;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
