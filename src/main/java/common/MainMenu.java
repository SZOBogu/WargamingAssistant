package common;

import diceRollSimulator.DiceRollMenu;
import rosterBuilder.T9A_Initializer;
import rosterBuilder.WargameSystemsInitializer;
import rosterBuilder.WargamingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenu extends JFrame implements ActionListener {
    private JButton scenButton;
    private JButton diceButton;
    private JButton rosterButton;
    private ArrayList<WargamingSystem> wargamingSystems;

    public MainMenu() {
        super("Main Menu");

        this.scenButton = new JButton("Scenario Generator");
        this.diceButton = new JButton("Dice Roll Simulator");
        this.rosterButton = new JButton("Roster Builder");
        this.wargamingSystems = new ArrayList<>();
        WargameSystemsInitializer initializer = new WargameSystemsInitializer();
        this.wargamingSystems.addAll(initializer.initialize());
        this.scenButton.addActionListener(this);
        this.diceButton.addActionListener(this);
        this.rosterButton.addActionListener(this);

        setMinimumSize(new Dimension(600, 400));
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.layoutComponents();
    }

    private void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weightx = 0.1;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        //Pierwszy rzad
        gbc.gridy = 0;
        add(scenButton, gbc);

        //nastepny rzad
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(diceButton, gbc);

        //nastepny rzad
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(rosterButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        if(clicked == rosterButton) {
            SystemSelectionMenu systemSelectionMenu = new SystemSelectionMenu(this.wargamingSystems, ModulesEnum.ROSTER_BUILDER);
            this.dispose();
        }
        else if(clicked == scenButton){
            SystemSelectionMenu systemSelectionMenu = new SystemSelectionMenu(this.wargamingSystems, ModulesEnum.SCENARIO_CREATOR);
            this.dispose();
        }
        else if(clicked == diceButton){
            DiceRollMenu diceRollMenu = new DiceRollMenu();
            this.dispose();
        }
    }
}
