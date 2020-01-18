package diceRollSimulator;

import javax.swing.*;
import java.awt.*;

public class DiceRollMenu extends JFrame{
    private TextPanel textPanel;
    private FormPanel form;
    private Controller controller;
    private TablePanel tablePanel;

    public DiceRollMenu(){
        super("main frame");
        setLayout(new BorderLayout());
        this.textPanel = new TextPanel();
        this.form = new FormPanel();
        this.tablePanel = new TablePanel();
        this.controller = new Controller();

        tablePanel.setData(controller.getDiceRolls());
        tablePanel.setTableListener(new TableListener(){
            public void rowDeleted(int row){
                controller.removeDiceRoll(row);
            }
        });
        form.setFormListener(new FormListener(){
            public void formEventOccurred(FormEvent event){
                controller.addDiceRoll(event);
                tablePanel.refresh();
            }
        });
        form.setClearListener(new ClearListener() {
            @Override
            public void clearButtonPressed() {
                controller.clear();
                tablePanel.refresh();
            }
        });
        form.setRunListener(new RunListener() {
            @Override
            public void run() {
                textPanel.appendText(controller.run() + "\n---------------------");
            }
        });
        form.setNonRandomRunListener(new NonRandomRunListener() {
            @Override
            public void runNonRandom() {
                textPanel.appendText(controller.runNonRandom() + "\n---------------------");
            }
        });

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx=0;
        gbc.gridy=0;
        add(form, gbc);
        gbc.gridx++;
        add(tablePanel, gbc);
        gbc.gridy++;
        add(textPanel, gbc);

        setMinimumSize(new Dimension(800, 600));
        setSize(1100,  800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}