import data.links.vizits.*;
import data.links.places.*;
import data.links.products.*;
import data.links.purchases.*;
import fileWorks.*;

import java.io.*;
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

//        place = new Places("Корона", "Маяковского-Денисовская");
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

//        vizit = new Vizits(7, 4, 2025, 1);
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



//        Fileworks.writePurchasesToFile("./src/data/links/files/purchases.txt");

        for (Places pl : Places.getPlacesArray()) {
            System.out.println(pl);
        }
        System.out.println("--------------------------------------");
        for (Products pr : Products.getProductsArray()) {
            System.out.println(pr);
        }
        System.out.println("--------------------------------------");



        System.out.println("********************************************");
        for (Purchases purch: Purchases.getPurchasesArray()) {
            System.out.println(purch.toString());
        }



        for (Vizits vz : Vizits.getVizitsArray()) {
            System.out.println(vz);
        }
        Fileworks.writeVizitsToFile("./src/data/links/files/vizits.txt");
        Fileworks.writePurchasesToFile("./src/data/links/files/purchases.txt");
        Fileworks.writeProductsToFile("./src/data/links/files/products.txt");
        Fileworks.writePlacesToFile("./src/data/links/files/places.txt");


//        System.out.println("Игры с датой -------------------------------");
//        Date date_1 = new Date();
//        System.out.println(date_1.toString());
//        System.out.println("day: " + date_1.getDate() + "/" + (date_1.getMonth()+1) + "/" + (date_1.getYear()+1900));
//        System.out.println("Конец игр с датой -------------------------------");

    }
}
