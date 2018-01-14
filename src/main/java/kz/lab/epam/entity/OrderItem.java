package kz.lab.epam.entity;

public class OrderItem {

    private Long ID_order;
    private Long ID_autoPart;
    private Integer count;


    public Long getID_order() {
        return ID_order;
    }

    public void setID_order(Long ID_order) {
        this.ID_order = ID_order;
    }

    public Long getID_autoPart() {
        return ID_autoPart;
    }

    public void setID_autoPart(Long ID_autoPart) {
        this.ID_autoPart = ID_autoPart;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
