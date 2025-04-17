package data.links.purchases;

import data.links.vizits.*;
import data.links.products.*;

import java.util.*;

public class Purchases {
    private static long currentID = 0;
    public long id; // id продукта
    public long vizitID; // id визита ссылка
    public long productID; // id продукта ссылка
    public double quantity; // количество продукта
    public double price; // цена продукта
    public double summa; // стоимость покупки
    public String currency; // валюта платежа
//    public int quantity;

    public static ArrayList<Purchases> purchasesArray = new ArrayList<>();
    public static HashMap<Long, Purchases> purchasesMap = new HashMap<>();
    public static HashMap<Long, Long> mapVizitPurchase = new HashMap<>();

    public Purchases(long vizitID, long productID, double quantity, double price, String currency) {
        this.id = ++currentID;
        this.vizitID = vizitID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.summa = quantity * price;
        purchasesArray.add(this);
        purchasesMap.put(this.id, this);
        mapVizitPurchase.put(vizitID, id);
        System.out.println("!!!!!!");
        System.out.println("mapVizitPurchase.entrySet() (из конструктора объекта):");
        for(Map.Entry<Long, Long> itm: Purchases.mapVizitPurchase.entrySet()) {
            System.out.println(itm);
            System.out.println(itm.getKey() + " --> "); // + itm.getValue());
        }
    }

    public Purchases(long id, long vizitID, long productID, double quantity, double price, String currency) {
        this.id = id;
        this.vizitID = vizitID;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
        this.currency = currency;
        this.summa = quantity * price;
        purchasesArray.add(this);
        purchasesMap.put(this.id, this);
    }

    public static ArrayList<Purchases> getPurchasesArray() {
        return purchasesArray;
    }
    public static Purchases getPurchase(long id) {
        return purchasesMap.get(id);
    }

    public static long getCurrentID() {
        return  currentID;
    }

    public static void setCurrentID(long currentID) {
        Purchases.currentID = currentID;
    }

    @Override
    public String toString() {
        return "Покупка (id " + id + "):                                 " + "\n"
                + "   " +  Vizits.getVizit(vizitID).toString() + ", " + "\n"
                + "   " + "id " + Products.getProduct(productID).id + ": " +  Products.getProduct(productID).name + " - "
                + "   " +  quantity + " " + Products.getProduct(productID).units + ", "
                + "   " +  "цена: " + price + " " + currency + ", "
                + "   " +  "стоимость: " + summa + " " + currency + "; ";
    }
}
