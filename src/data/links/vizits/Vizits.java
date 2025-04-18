package data.links.vizits;

import data.links.places.*;

import java.util.*;

public class Vizits {
    private static long currentID = 0; // максимальное значение id в классе на данный момент
    public long id;
    public Date date;
    public long placeID;
    public static long maxID = 0; // максимальное значение id в классе

    public static ArrayList<Vizits> vizitsArray = new ArrayList<>();
    public static HashMap<Long, Vizits> vizitsMap = new HashMap<>();

    public Vizits(int dDate, int mDate, int yDate, long placeID) {
        this.id = ++currentID;
        this.date = new Date();
        System.out.println(date.toString());
        this.date.setDate(dDate);
        this.date.setMonth(mDate);
        this.date.setYear(yDate);
        this.placeID = placeID;
        vizitsArray.add(this);
        vizitsMap.put(this.id, this);
    }

    public Vizits(long id, int dDate, int mDate, int yDate, long placeID) {

        this.id = id;
        this.date = new Date();
//        System.out.println(date.toString());
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
    public static String getArrayForWrite() {
        String result="";
        for (Vizits vizit: vizitsArray) {
            result = vizit.id + ";" +
                     vizit.date.getDate() + ";" +
                     vizit.date.getMonth() + ";" +
                     vizit.date.getYear() + ";" +
                     vizit.placeID + ";" +
                    "\n";
        }
        if (result == "")  {
            result = "Данных нет";
        }
        return result;
    }

    public static void setCurrentID(long maxID) {
        Vizits.currentID = maxID;
    }

    public static long getCurrentID() {
        return currentID;
    }

    @Override
    public String toString() {
//        System.out.println("____ из Vizits toString ----------");
        return "Визит (id " + id + "): "
                + "day: " + date.getDate() + "/" + date.getMonth() + "/" + date.getYear() + ", ";
//                + " "  +  Places.getPlace(placeID);
    }
}
