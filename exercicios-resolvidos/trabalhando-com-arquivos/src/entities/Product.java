package entities;

public class Product {
    private String name;
    private Double price;
    private Integer amount;

    public Product(String name, Double price, Integer amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
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

    public Integer getAmount() {
        return amount;
    }

    public Double totalValue(){
        return price * amount;
    }
}
