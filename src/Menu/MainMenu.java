package Menu;

import data.links.vizits.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class MainMenu extends JFrame {
    private static final int WINDOW_HEIGHT = 500;
    private static final int WINDOW_WIDTH = 1500;
    private static final int WINDOW_POSX = 0;
    private static final int WINDOW_POSY = 50;

    public MainMenu() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Визиты");
        setResizable(false);
        setLayout(new GridLayout(3,1));
//        GridLayout menuGrid = new GridLayout(1,2);

        // Создаем панель для размещения двух верхних элементов

        JPanel panel_1 = new JPanel(new GridLayout(1,2));

        Vizits[] itms = new Vizits[10]; // Массив значений списка (массив визмтов)

        ArrayList<Vizits> arrVizits = Vizits.getVizitsArray(); // получаем ArrayList из Vizits
//        System.out.println("List of Vizits");
        //  Заполняем массив визитов
        for(int i = 0; i < arrVizits.size(); i++) {
            itms[i] = arrVizits.get(i);
            System.out.println(itms[i]);
        }
        JList vList = new JList(itms); // создаем элемент-список визитов
        JPanel vListPanel = new JPanel(); // создаем панель для списка визитов в главном окне
        vListPanel.setLocation(0,750);
        vListPanel.setBorder(BorderFactory.createLineBorder(Color.red, 2));
        vListPanel.add(new JScrollPane(vList));

        // Возня с созданием пустой панели
        JPanel emptyPanel = new JPanel();
        JLabel labelX = new JLabel("Эта метка стоит в пустой панели");
        labelX.setBorder(BorderFactory.createLineBorder(Color.green, 2));
        emptyPanel.add(labelX);
        emptyPanel.setBorder(BorderFactory.createLineBorder(Color.blue, 12));
        emptyPanel.setLocation(0,0);

        panel_1.add(vListPanel);
        panel_1.add(emptyPanel);
        panel_1.setBorder(BorderFactory.createLineBorder(Color.black, 3));

        // Создаем среднюю панель кнопок
        JPanel panel_2 = new JPanel(new GridLayout(1, 5));
        // Создаем кнопки для средней панели кнопок
        JButton but_1 = new JButton("Кнопка 1");
        but_1.setSize(300, 50);
        JButton but_2 = new JButton("Кнопка 2");
        but_2.setSize(300, 50);
        JButton but_3 = new JButton("Кнопка 3");
        but_3.setSize(300, 50);
        JButton but_4 = new JButton("Кнопка 4");
        but_4.setSize(300, 50);
        JButton but_5 = new JButton("Кнопка 5");
        but_5.setSize(300, 50);
        // Добавляем кнопки средней панели кнопок на среднюю панель кнопок
        panel_2.add(but_1);
        panel_2.add(but_2);
        panel_2.add(but_3);
        panel_2.add(but_4);
        panel_2.add(but_5);

        // Создаем нижнюю панель кнопок
        JPanel bottomPanel = new JPanel();
        JButton btnStart = new JButton("Start");
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Нажата кнопка Start");
            }
        });

        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() { // добавление нового слушателя действий.
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panel_1.add(vListPanel);
        panel_1.add(emptyPanel);
        add(panel_1);
        add(panel_2);

        bottomPanel.add(btnStart);
        bottomPanel.add(btnExit);
        add(bottomPanel);
    setVisible(true);
}
}

