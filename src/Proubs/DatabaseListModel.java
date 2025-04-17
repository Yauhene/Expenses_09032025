package Proubs;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

/** Листинг получен из https://java-online.ru/swing-jlist.xhtml
 *
 */
public class DatabaseListModel extends AbstractListModel<String>{
    // Коллекция для хранения данных
    private ArrayList<String> data = new ArrayList<String>();
    // Загрузка данных из БД
    public void setDataSource(ResultSet rs, String column)
    {
        try {
            // Очистка коллекции
            data.clear();
            // Перебор в цикле данных
            while ( rs.next() ) {
                synchronized ( data ) {
                    // Добавление данных в коллекцию
                    data.add(rs.getString(column));
                }
                // Оповещение видов о добавлении, если они есть
                fireIntervalAdded(this, 0, data.size());
            }
            rs.close();
            // Оповещение видов об изменении
            fireContentsChanged(this, 0, data.size());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
    // Функция размера массива данных в списке
    public int getSize() {
        synchronized ( data ) {
            return data.size();
        }
    }
    // Функция извлечения элемента
    public String getElementAt(int idx) {
        synchronized ( data ) {
            return data.get(idx);
        }
    }
}
