import places.*;
import products.*;

import java.util.*;

public class Start {
    public static Places place;
    public static Products product;

    public static void main(String[] args) {
        System.out.println("Hi !!!");
        place = new Places("Корона", "Маяковского-Денисовская");
        place = new Places("Гиппо", "Рокоссовского");
        place = new Places("MOMO", "Партизанский пр-т");

        product = new Products(1, "Чебуреки с говядиной");
        product = new Products(1, "Сосиски");
        product = new Products(1, "Носорог тушеный, 400 г");



//        System.out.println(plArr);
        for (Places pl : Places.getPlacesArray()) {
            System.out.println(pl);
        }

        System.out.println("--------------------------------------");

        for (Products pr : Products.getProductsArray()) {
            System.out.println(pr);
        }

    }
}
