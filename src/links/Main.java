package links;

public class Main {
    public static void main(String[] args) {
        Unit unit1 = new Unit("Первый юнит пошел");
        System.out.println("Собственный id: " + unit1.getId());
        System.out.println("id класса: " + Unit.classID);
        Unit unit2 = new Unit("Второй юнит пошел");
        System.out.println("Собственный id: " + unit2.getId());
        System.out.println("id класса: " + Unit.classID);
        Unit unit3 = new Unit("Третий юнит пошел");
        System.out.println("Собственный id: " + unit3.getId());
        System.out.println("id класса: " + Unit.classID);

        Some some1 = new Some("Первое нечто пошло");
        Some some2 = new Some("Второе нечто пошло");
        Some some3 = new Some("Третье нечто пошло");

        Link<Unit> linkU1 = new Link<>(unit1);
        Link<Some> linkS1 = new Link<>(some1);

        Unit u = linkU1.getElement();
        System.out.println(u.getText());

        Some s = linkS1.getElement();
        System.out.println(s.getText());
//        System.out.println(linkU1.getLink());

    }
}
