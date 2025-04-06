package Vizits;

import places.*;

import java.util.*;

public class Vizits {
    private static long currentID = 1;
    public long id;
    public Date date;
    public long placeID;

    public static ArrayList<Vizits> vizitsArray = new ArrayList<>();
    public static HashMap<Long, Vizits> vizitsMap = new HashMap<>();

    public Vizits(int dDate, int mDate, int yDate, long placeID) {
        this.id = currentID++;
        this.date = new Date();
        System.out.println(date.toString());
        this.date.setDate(dDate);
        this.date.setMonth(mDate);
        this.date.setYear(yDate);
        this.placeID = placeID;
        vizitsArray.add(this);
        vizitsMap.put(this.id, this);
    }

    public static ArrayList<Vizits> getVizitsArray() {
        return vizitsArray;
    }
    public static Vizits getVizit(long id) {
        return vizitsMap.get(id);
    }

    @Override
    public String toString() {
        return "Визит (id " + id + "): "
                + "day: " + date.getDate() + "/" + date.getMonth() + "/" + date.getYear() + ", "
                + " " +  Places.getPlace(placeID);
    }
}
