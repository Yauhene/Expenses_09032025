package data.links.places;

import java.sql.*;
import java.util.*;

public class Places {
    private static long currentID = 0;
    public long id;
    public String name;
    public String location;

    public static ArrayList<Places> placesArray = new ArrayList<>();
    public static HashMap<Long, Places> placesMap = new HashMap<>();

    public Places(String name, String location) {
        this.id = ++currentID;
        this.name = name;
        this.location = location;
        placesArray.add(this);
        placesMap.put(this.id, this);
    }

    public Places(long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
        placesArray.add(this);
        placesMap.put(this.id, this);
    }

    public static ArrayList<Places> getPlacesArrayList() {
        return placesArray;
    }

    public static long getCurrentID() {
        return currentID;
    }

    public static void setCurrentID(long currentID) {
        Places.currentID = currentID;
    }

    public static Places getPlace(long id) {
        return placesMap.get(id);
    }

    public static String[] getLocationsStringArray() {
        String[] arr = new String[placesArray.size()];
        for (int i = 0; i < placesArray.size(); i++) {
            arr[i] =placesArray.get(i).location;
        }
        return arr;
    }

    @Override
    public String toString() {
       return "Место (id " + id + "): "
                    + name + ", "
                    + location;
    }
}
