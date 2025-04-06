package purchases;

import Vizits.*;
import products.*;

import java.util.*;

public class Purchases {
    private static long currentID = 1;
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

    public Purchases(long vizitID, long productID, double quantity, double price, String currency) {
        this.id=currentID++;
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
