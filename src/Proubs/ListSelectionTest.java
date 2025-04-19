package Proubs;

// Пример использования различных режимов выделения
import javax.swing.*;
import java.awt.*;

public class ListSelectionTest extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private String[] data = { "Футбол", "Хоккей", "Баскетбол", "Биатлон", "Лыжи"};
	public ListSelectionTest()
	{
		super("Пример модели выделения");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Модель данных
		DefaultListModel<String> dlm = new DefaultListModel<String>();
		for (String string : data) 
			dlm.addElement(string);
		// Списки для разных типов выделения
		JList<String> lst_single   = new JList<String>(dlm);
		JList<String> lst_interval = new JList<String>(dlm);
		JList<String> multiple     = new JList<String>(dlm);
		// Определение максимальной ширины списка
		lst_single.setPrototypeCellValue("Установленный размер");
		// Модели выделения
		lst_single  .setSelectionMode(ListSelectionModel.SINGLE_SELECTION           );
		lst_interval.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION  );
		multiple    .setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        // Выделение строки списков
		lst_single  .setSelectedIndex(2);
		lst_interval.setSelectionInterval(1, 1);
		lst_interval.addSelectionInterval(2, 3);
		// Список выделяемых строк
//		int[] rows = {0, 2, 4};
		int[] rows = {1};
		multiple .setSelectedIndices(rows); 
		// Добавляем компоненты в интерфейс
		JPanel contents = new JPanel();
		contents.add(new JScrollPane(lst_single  ));
		contents.add(new JScrollPane(lst_interval));
		contents.add(new JScrollPane(multiple    ));
		// Вывод окна
		setContentPane(contents);
		setSize(360, 200);
		setVisible(true);

		// 1 Отсебятина, отображение состояния (выделен/нет) элементов списка
		int[] arr =  multiple.getSelectedIndices(); // получаем массив индексов выделенных элементов multiple
		for(int i = 0; i < arr.length; i++) { // выводим значения индексов
			System.out.println(arr[i]);
		}
	}
	public static void main(String[] args) {
		new ListSelectionTest();
	}

    /**
     * @author DarkRaha
     *
     */
    public static class MyWin extends JFrame {

        // серийный номер класса
        private static final long serialVersionUID = 1L;

        public MyWin() {
            Container c = getContentPane(); // клиентская область окна
            c.setLayout(new BorderLayout()); // выбираем компоновщик

            // добавляем какие-нибудь дочерние элементы
            //MyComponent child = new MyComponent();
            MyPanel child= new MyPanel();
            c.add(child);

            // -------------------------------------------
            // настройка окна
            setTitle("Example window"); // заголовок окна
            // желательные размеры окна
            setPreferredSize(new Dimension(640, 480));
            // завершить приложение при закрытии окна
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack(); // устанавливаем желательные размеры
            setVisible(true); // отображаем окно
        }

        // запуск оконного приложения
        public static void main(String args[]) {
            new MyWin();
        }
    }
}
