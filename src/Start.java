import places.*;

import java.util.*;

public class Start {
    public static Places place;

    public static void main(String[] args) {
        System.out.println("Hi !!!");
        place = new Places("Корона", "Маяковского-Денисовская");
        place = new Places("Гиппо", "Рокоссовского");
        place = new Places("MOMO", "Партизанский пр-т");
//        System.out.println(plArr);
        for (Places pl : Places.getPlacesArray()) {
            System.out.println(pl);
        }

    }
}
