package kz.lab.epam.entity;

public class AutoPart {

    private long id;
    private String articule;
    private String name;
    private AutoPartType autoPartType;
    private Double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getArticule() {
        return articule;
    }

    public void setArticule(String articule) {
        this.articule = articule;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AutoPartType getAutoPartType() {
        return autoPartType;
    }

    public void setAutoPartType(AutoPartType autoPartType) {
        this.autoPartType = autoPartType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
