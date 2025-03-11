package products;

public class ProductLink {
    private static long elCount = 0;
    private long id;
    public final Products product;
    public ProductLink next;
    public ProductLink prev;

    ProductLink(long id, Products product) {
        this.id = id;
        this.product = product;
        elCount = elCount++;
    }

    public long getId() {
        return id;
    }
}
