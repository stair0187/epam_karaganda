package kz.lab.epam;

public class Order {

    private Long ID;
    private Long ID_user;
    private Double total;
    private OrderStatus orderStatus;


    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID_user() {
        return ID_user;
    }

    public void setID_user(Long ID_user) {
        this.ID_user = ID_user;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
}
