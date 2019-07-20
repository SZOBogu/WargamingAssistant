package diceRollSimulator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TablePanel extends JPanel {
   // private JLabel diceQuantityLabel;
    private JTable table;
    private TableModel tableModel;
    private JPopupMenu popupMenu;
    private TableListener tableListener;

    public TablePanel(){
        //this.diceQuantityLabel = new JLabel();
        this.tableModel = new TableModel();
        this.table = new JTable(tableModel);
        this.popupMenu = new JPopupMenu();

        JMenuItem removeItem = new JMenuItem("Delete Row");
        popupMenu.add(removeItem);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                table.getSelectionModel().setSelectionInterval(row, row);

                if(e.getButton() == MouseEvent.BUTTON3);
                popupMenu.show(table, e.getX(), e.getY());
            }
        });

        removeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row = table.getSelectedRow();
                if(tableListener != null){
                    tableListener.rowDeleted(row);
                    tableModel.fireTableRowsDeleted(row, row);
                }
            }
        });
        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(ArrayList<DiceRoll> db){
        tableModel.setData(db);
    }

    public void refresh(){
        tableModel.fireTableDataChanged();
    }

    public void setTableListener(TableListener listener){
        this.tableListener = listener;
    }
}
