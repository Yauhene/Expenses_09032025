package products;

import places.*;

import java.util.*;

public class Products {
    private static long currentID = 1;
    public long id;
    public long typeID;
    public String name;
//    public String units;
//    public int quantity;

    public static ArrayList<Products> productsArray = new ArrayList<>();

    public Products(long typeID, String name) {
        this.id=currentID++;
        this.typeID = typeID;
        this.name = name;
        productsArray.add(this);
    }

    public static ArrayList<Products> getProductsArray() {
        return productsArray;
    }

    @Override
    public String toString() {
        return "Продукт " + id + ": "
                + "тип продукта: " + typeID + ", "
                + "название: " + name;
    }
}
