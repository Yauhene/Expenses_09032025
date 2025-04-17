package Menu;

// Пример тестирования слушателя ListSelectionListener

import data.links.products.*;
import data.links.purchases.*;
import data.links.vizits.*;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.util.*;

public class Menu_1 extends JFrame
{
	// Данные списка
//	private final String[]   dataList = { "Бакалея", "Напитки", "Хлеб"};
	ArrayList<Vizits> arrVizits = Vizits.getVizitsArray(); // делаем копию Vizits.vizitsArrayList
	private final String[]   dataList = new String[arrVizits.size()]; // массив данных для отображения
	// Мапа индекс в dataList --> id визита
	HashMap<Integer, Long> mapDataList = new HashMap<>();


	private final String[][] dataText = {{"Сахар", "Мука", "Соль"},
			{"Чай"  , "Кофе", "Морс"},
			{"Батон", "Пшеничный", "Бородинский"}};
	private JTextArea content;

	public Menu_1()
	{
		super("Слушатель событий списка");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Набиваем данными dataList
		for(int i = 0; i < arrVizits.size(); i++) {
			dataList[i] = arrVizits.get(i).id + ". " + arrVizits.get(i).toString();
			mapDataList.put(i, arrVizits.get(i).id);
		}
		// Создание списка
		JPanel contents = new JPanel();
		final JList<String> list = new JList<String>(dataList);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setPrototypeCellValue("Визит (id 8): day: 7/4/2025,  Место (id 1): Корона, Маяковского-Денисовская                  ");
		// Создание текстового поля
		content = new JTextArea(5, 40);
		System.out.println("mapVizitPurchase.entrySet():");
		for(Map.Entry<Long, Long> itm: Purchases.mapVizitPurchase.entrySet()) {
			System.out.println(itm.getKey() + " --> " + itm.getValue());
		}
		// Подключения слушателя
		list.addListSelectionListener(new listSelectionListener());
		// Подключение слушателя мыши
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if ( e.getClickCount() == 2 ) {
					// Получение элемента
					int selected = list.locationToIndex(e.getPoint());
					System.out.println("selected " + selected);
					int i = 0;
//					String txt = "";
//					while (i < dataText[selected].length)
//						txt += dataText[selected][i++] + "\n";
					content.setText(makeContent(selected));
				}
			}
		});
		showArrayDataList();

		// Размещение компонентов в интерфейсе
		contents.add(new JLabel("Список разделов"));
		contents.add(new JScrollPane(list));
		contents.add(new JLabel("Содержимое разделов"));
		contents.add(new JScrollPane(content));
		// Вывод окна
		setContentPane(contents);
		setSize(1400, 200);
		setVisible(true);
	}
	/*
	 * Слушатель списка
	 */
	class listSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			// Выделенная строка
			int selected = ((JList<?>)e.getSource()).getSelectedIndex();
			System.out.println ("Выделенная строка : " +
					String.valueOf(selected));
		}
	}
	public void showArrayDataList() { // показать содержимое dataList
		System.out.println("Количество элементов dataList: " + dataList.length);
		for(int i = 0; i < dataList.length; i++) {
			System.out.println("index " + i + ", " + dataList[i]);
		}
	}

	public String makeContent(Integer id) {
		long vizitID = mapDataList.get(id); // находим id визита в мапе
		System.out.println("vizitID: " + vizitID);
		for(Map.Entry<Long, Long> itm: Purchases.mapVizitPurchase.entrySet()) {
			System.out.println(itm.getKey() + " --> " + itm.getValue());
		}
		long purchaseID = Purchases.mapVizitPurchase.get(vizitID);
		System.out.println("purchaseID " + purchaseID);
		System.out.println("... вошли в makeContent");
		String str = ""; // строка-накопитель для значений покупок
		for(Purchases purch: Purchases.getPurchasesArray()) {
			if (purch.vizitID == vizitID) {
				str = str + purch.toString() + "\n";
			}
		}
		return str;
	}

	public static void main(String[] args) {
		new Menu_1();
	}
}
