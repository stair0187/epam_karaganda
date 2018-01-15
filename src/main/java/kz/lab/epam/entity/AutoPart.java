package kz.lab.epam.entity;

public class AutoPart {

    private int id;
    private String article;
    private String name;
    private AutoPartType autoPartType;
    private Double price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public AutoPartType getAutoPartType() {
        return autoPartType;
    }

    public void setAutoPartType(AutoPartType autoPartType) {
        this.autoPartType = autoPartType;
    }
}
