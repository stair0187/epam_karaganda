package kz.lab.epam.entity;

public class CartItem {

    private Long cart_id;
    private Long autopart_id;
    private Integer count;

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }


    public Long getAutopart_id() {
        return autopart_id;
    }

    public void setAutopart_id(Long autopart_id) {
        this.autopart_id = autopart_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
