/**
 * Created by dell on 12-Apr-17.
 */
package my.apps.web;

public class Article {
    private Long id;
    private String product;
    private int quantity;

    public Article(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Article{" +
                "product='" + product + '\'' +
                "quantity='" + quantity + '\'' +
                "}";
    }
}
