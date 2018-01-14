package kz.lab.epam;

public class AutoPart {

    private int ID;
    private String article;
    private String name;
    private AutoPartType autoPartType;
    private Double price;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
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
