package places;

import java.util.*;

public class Places {
    private static long currentID = 1;
    public long id;
    public String name;
    public String location;

    public static ArrayList<Places> placesArray = new ArrayList<>();

    public Places(String name, String location) {
        this.id = currentID++;
        this.name = name;
        this.location = location;
        placesArray.add(this);
    }

    public static ArrayList<Places> getPlacesArray() {
        return placesArray;
    }

    @Override
    public String toString() {
       return "Место " + id + ": "
                    + name + ", "
                    + location;
    }
}
