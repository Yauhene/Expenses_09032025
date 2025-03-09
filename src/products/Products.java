package products;

import places.*;

import java.util.*;

public class Products {
    private static long currentID = 1;
    public long id;
    public long typeID;
    public String name;
    public String units;
    public int quantity;

    public static ArrayList<Places> placesArray = new ArrayList<>();
}
