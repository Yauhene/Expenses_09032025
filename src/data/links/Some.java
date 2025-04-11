package data.links;

public class Some {
    public static long id = 0;
    private String text;

    public Some(String text) {
        this.text = text;
        id = ++id;
        System.out.println("Создано нечто: " + this.text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    @Override
    public String toString() {
        return "id: " + id +
                ", text: " + text;
    }
}
