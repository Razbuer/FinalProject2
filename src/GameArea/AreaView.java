package GameArea;

import util.Settings;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.Arrays;
import java.util.Properties;

public class AreaView extends JFrame {
    private final Properties properties = Settings.getProperties();
    public static JTable table;
    public static JTextArea info;

    // Данные для таблиц
    private Object[][] array = new String[Integer.parseInt(properties.getProperty("areaHeight"))][Integer.parseInt(properties.getProperty("areaWidth"))];
    // Заголовки столбцов
    private Object[] columnsHeader = new String[Integer.parseInt(properties.getProperty("areaWidth"))];

    public AreaView() {
        super("Итоговый Проект №2");
        // Закрытие окна
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Cоздание многострочных полей
        info = new JTextArea("Статистика");
        info.setFont(new Font("Dialog", Font.PLAIN, 18));

        // Пустая таблица таблица
        columnsHeader = Arrays.stream(columnsHeader).map((s) -> " ").toArray();

        table = new JTable(array, columnsHeader){
            @Override
            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
                Component component = super.prepareRenderer(renderer, row, column);
                int rendererWidth = component.getPreferredSize().width;
                TableColumn tableColumn = getColumnModel().getColumn(column);
                tableColumn.setPreferredWidth(Math.max(rendererWidth + getIntercellSpacing().width, tableColumn.getPreferredWidth()));
                setFont(getFont().deriveFont(14f));
                return component;
            }
        };
        table.setTableHeader(null);

        // Выравниевание текста по центру
        DefaultTableCellRenderer renderer = (DefaultTableCellRenderer)table.getDefaultRenderer(String.class);
        renderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Размещение таблиц в панели с блочным расположением
        Box contents = new Box(BoxLayout.PAGE_AXIS);
        contents.add(new JScrollPane(info));
        contents.add(new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        // Вывод окна на экран
        setContentPane(contents);
        // Во весь экран
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);

    }
}
