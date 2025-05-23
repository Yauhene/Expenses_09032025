package data.links.products;

import java.util.*;

public class Products {
    private static long currentID = 0;
    public long id; // id продукта
    public long typeID; // тип продукта
    public String name; // название продукта
    public String units;
//    public int quantity;

    public static ArrayList<Products> productsArray = new ArrayList<>();
    public static HashMap<Long, Products> productsMap = new HashMap<>();

    public Products(long typeID, String name, String units) {
        this.id = ++currentID;
        this.typeID = typeID;
        this.name = name;
        this.units = units;
        productsArray.add(this);
        productsMap.put(this.id, this);
    }

    public static long getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(long currentID) {
        Products.currentID = currentID;
    }

    public Products(long id, long typeID, String name, String units) {
        this.id = id;
        this.typeID = typeID;
        this.name = name;
        this.units = units;
        productsArray.add(this);
        productsMap.put(this.id, this);
    }

    public static ArrayList<Products> getProductsArray() {
        return productsArray;
    }
    public static Products getProduct(long id) {
        return productsMap.get(id);
    }

    @Override
    public String toString() {
        return "Продукт " + id + ": "
                + "тип: " + typeID + ", "
                + name + ", "
                + "ед.измер-я: " + units;
    }
}
