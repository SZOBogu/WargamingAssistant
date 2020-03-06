package diceRollSimulator;

import javax.swing.*;
import java.awt.*;

public class DiceRollMenu extends JFrame{
    private TextPanel textPanel;
    private Controller controller;
    private TablePanel tablePanel;

    public DiceRollMenu(){
        super("Dice Roll Menu");
        setLayout(new BorderLayout());
        this.textPanel = new TextPanel();
        FormPanel form = new FormPanel();
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
        form.setClearListener(() -> {
            controller.clear();
            tablePanel.refresh();
        });
        form.setRunListener(() -> textPanel.appendText(controller.run() + "\n---------------------"));
        form.setNonRandomRunListener(() -> textPanel.appendText(controller.runNonRandom() + "\n---------------------"));

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
