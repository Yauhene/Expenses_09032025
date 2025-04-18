import Menu.*;
import Proubs.*;
import data.links.vizits.*;
import data.links.places.*;
import data.links.products.*;
import data.links.purchases.*;
import fileWorks.*;

import java.io.*;
import java.util.*;

import static data.links.purchases.Purchases.*;
//import vizits.*;


public class Start {
    public static Places place;
    public static Products product;
    public static Vizits vizit;
    public static Purchases purchase;

    public static void main(String[] args) throws IOException {
        Fileworks.readVizitsFromFile("./src/data/links/files/vizits.txt");
        Fileworks.readPurchasesFromFile("./src/data/links/files/purchases.txt");
        Fileworks.readProductsFromFile("./src/data/links/files/products.txt");
        Fileworks.readPlacesFromFile("./src/data/links/files/places.txt");

//        place = new Places("Зеленая грядка", "возле \"Евроопта\"");

//        place = new Places("Гиппо", "Рокоссовского");
//        place = new Places("MOMO", "Партизанский пр-т");

//        product = new Products(1, "Чебуреки с говядиной", "г");
//        product = new Products(1, "Сосиски","г");
//        product = new Products(1, "Носорог тушеный, 400 г","г");

//        product = new Products(2, "Пакет-майка", "шт.");
//        product = new Products(1, "Чиабатта Европейская", "шт.");
//        product = new Products(1, "Вареники Бабушка Аня с вишней, пакет 430 г", "шт.");
//        product = new Products(1,  "Вареники Бабушка Аня с малиной, пакет 430 г", "шт.");
//        product = new Products(1,  "Вареники Бабушка Аня с черникой, пакет 430 г", "шт.");
//        product = new Products(1,  "Пельмени Добровские с говядиной, пачка 400 г", "шт.");
//        product = new Products(1,  "Рулет Маковый соблазн, 300 г", "шт.");
//        product = new Products(1,  "Перец горошек, пачка 20 г", "шт.");
//        product = new Products(1,  "Колбаса Еврейская", "г");
//        product = new Products(1,  "Колбаса С сальцем", "кг");
//        product = new Products(1, "Лук репчатый", "кг");

//        vizit = new Vizits(7, 4, 2025, 4);
//        vizit = new Vizits(18, 4, 2025, 4);
//        System.out.println(vizit.id + " " + vizit.date);

//        purchase = new Purchases(1,1,2,0.49, "руб.");
//        purchase = new Purchases(1,2,1,1.90, "руб.");
//        purchase = new Purchases(1,3,1,5.78, "руб.");
//        purchase = new Purchases(1,4,1,5.43, "руб.");
//        purchase = new Purchases(1,5,1,5.72, "руб.");
//        purchase = new Purchases(1,6,2,5.64, "руб.");
//        purchase = new Purchases(1,7,1,3.50, "руб.");
//        purchase = new Purchases(1,8,1,3.47, "руб.");
//        purchase = new Purchases(1,9,0.138 ,36.97, "руб.");
//        purchase = new Purchases(1,10,0.282,11.65, "руб.");
//        purchase = new Purchases(4,11,0.7,1.75, "руб.");


//        Fileworks.writePurchasesToFile("./src/data/links/files/purchases.txt");

//        for (Places pl : Places.getPlacesArrayList()) {
//            System.out.println(pl);
//        }
//        System.out.println("--------------------------------------");
//        for (Products pr : Products.getProductsArray()) {
//            System.out.println(pr);
//        }
//        System.out.println("--------------------------------------");



        System.out.println("Распечатка  PurchasesArray из Start********************************************");
        for (Purchases purch: getPurchasesArray()) {
            System.out.println(purch.toString());
        }

//        if (!Purchases.purchasesMap.isEmpty()) {
//            for (Map.Entry<Long, Purchases> itm : Purchases.purchasesMap.entrySet()) {
//                System.out.println(itm);
//                System.out.println(itm.getKey() + " --> " + itm.getValue());
//            }
//        }
//        else {
//            System.out.println("Данные в mapVizitPurchase отсутствуют");
//        }
        System.out.println("---------- распечатка mapVizitPurchase из Start");
        Purchases.showMapVisitsPurchases();

        int mapSize = mapPurchaseVizit.size();


        Menu_1 visitsMenu = new Menu_1();
//        new ListModelTest();
//        System.out.println("Window started");

        Fileworks.writeVizitsToFile("./src/data/links/files/vizits.txt");
        Fileworks.writePurchasesToFile("./src/data/links/files/purchases.txt");
        Fileworks.writeProductsToFile("./src/data/links/files/products.txt");
        Fileworks.writePlacesToFile("./src/data/links/files/places.txt");

        System.out.println("Files saved");


//        System.out.println("Игры с датой -------------------------------");
//        Date date_1 = new Date();
//        System.out.println(date_1.toString());
//        System.out.println("day: " + date_1.getDate() + "/" + (date_1.getMonth()+1) + "/" + (date_1.getYear()+1900));
//        System.out.println("Конец игр с датой -------------------------------");

    }
}
