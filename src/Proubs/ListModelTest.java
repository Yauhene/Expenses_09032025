package Proubs;

import data.links.places.*;
import data.links.vizits.*;

import javax.swing.*;

import java.awt.event.*;
import java.util.*;

public class ListModelTest extends JFrame
{
    // Модель списка
    private DefaultListModel<String> dlm = new DefaultListModel<String>();

    private final String[] data1 = { "Чай" ,"Кофе"  ,"Минеральная","Морс"};
//1.  ****  Эксперимент с подсовыванием ArrayList вместо Array в data2
//    private final String[] data2 = { "Ясли","Детсад", "Школа", "Институт",
//            "Университет"};
    //Эксперимент провалился, зато удалось в data2 запихнуть локации из Places

    private final String[] data2 = Places.getLocationsStringArray();

    public ListModelTest()
    {
        super("Пример со списком JList");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Создание панели
        JPanel contents = new JPanel();

        // Наполнение модели данными
        for (String string : data2) {
            dlm.add(0, string);
            System.out.println(string);
        }
        // Создание кнопки
        JButton add = new JButton("Добавить");
        add.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("dlm.getSize(): " + dlm.getSize());
                System.out.println(dlm.getElementAt(dlm.getSize()-1));
                dlm.add(dlm.getSize(), "-- Новая запись --");
                System.out.println("new dlm.getSize(): " + dlm.getSize());
                System.out.println(dlm.getElementAt(dlm.getSize()-1));
                validate();
            }
        });
        JList<String> list1 = new JList<String>(data1);
        JList<String> list2 = new JList<String>(dlm);

        // Вектор данных
        Vector<String> big = new Vector<String>();
        for (int i=0; i < 15; i++) {
            big.add("~ " + i + ". ~");
        }
        JList<String> bigList = new JList<String>(big);
        bigList.setPrototypeCellValue("12345");

        // Размещение компонентов в панели
        contents.add(add);
        contents.add(new JScrollPane(list1));
        contents.add(new JScrollPane(list2));
        contents.add(new JScrollPane(bigList));

        setContentPane(contents);
        // Вывод окна
        setSize(400, 200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ListModelTest();
    }
}