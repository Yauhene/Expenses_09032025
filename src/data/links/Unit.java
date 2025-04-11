package data.links;

public class Unit {
    public static long classID = 0;
    private long id;
    private String text;

    public Unit(String text) {
        this.text = text;
        id = ++classID;
        System.out.println("Создан юнит: " + this.text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id: " + id +
                    ", text: " + text;
    }
}
