package kz.lab.epam.entity;

public class OrderItem {

    private Long orderId;
    private Long autopartId;
    private Integer count;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getAutopartId() {
        return autopartId;
    }

    public void setAutopartId(Long autopartId) {
        this.autopartId = autopartId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
