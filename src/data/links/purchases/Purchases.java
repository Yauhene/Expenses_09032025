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
    public static HashMap<Long, Long> mapPurchaseVizit = new HashMap<>();

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
        mapPurchaseVizit.put(this.id,this.vizitID);


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
        mapPurchaseVizit.put(this.id,this.vizitID);
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
        return "Покупка (id " + id + "):                                 "
                + " vizitID:" + vizitID
                + "   " + " productID: " + productID
                + "   quantity: " +  quantity
                + "   " +  "цена: " + price + " currency: " + currency + ", "
                + "   " +  "стоимость: " + summa + " " + currency + "; ";
    }

    public static void showMapVisitsPurchases() {
        System.out.println(" Распечатка mapVizitPurchase.entrySet() (из Purchases):");
//        System.out.println("mapVizitPurchase.entrySet().isEmpty() = " + mapVizitPurchase.entrySet().isEmpty());
        if (!mapPurchaseVizit.entrySet().isEmpty()) {
            for (Map.Entry<Long, Long> itm : Purchases.mapPurchaseVizit.entrySet()) {
                System.out.println(itm.getKey() + " --> " + itm.getValue());
            }
        }
        else {
            System.out.println("Данные в mapVizitPurchase отсутствуют");
        }
    }
}
