package common;

import rosterBuilder.Roster;
import rosterBuilder.RosterInfoDialog;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.ScenarioCreator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SystemSelectionMenu extends JFrame implements ActionListener {
    private ArrayList<JButton> buttons;
    private ModulesEnum furtherModule;
    private ArrayList<WargamingSystem> wargamingSystems;
    private JButton backButton;

    public SystemSelectionMenu(ArrayList<WargamingSystem> wargamingSystems, ModulesEnum furtherModule){
        super("System Selection Menu");
        this.furtherModule = furtherModule;
        this.wargamingSystems = wargamingSystems;
        this.buttons = new ArrayList<>();
        for(int i = 0; i < wargamingSystems.size(); i++){
            JButton button = new JButton(wargamingSystems.get(i).getName());
            button.addActionListener(this);
            buttons.add(button);
        }
        this.backButton = new JButton("Go Back");
        this.backButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(300, 200));
        setSize(300, 200);
        setMaximumSize(new Dimension(1000, 1800));
        setVisible(true);
        this.pack();
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
  //      gbc.anchor = GridBagConstraints.CENTER;

        for(int i = 0; i < this.buttons.size(); i++){
            add(this.buttons.get(i), gbc);
            gbc.gridy++;
        }
        gbc.gridy++;
        add(this.backButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        for(int i =0; i < this.buttons.size(); i++){
            if(this.buttons.get(i) == clicked && this.furtherModule == ModulesEnum.SCENARIO_CREATOR){
                ScenarioCreator scenarioCreator = new ScenarioCreator(this.wargamingSystems.get(i).getDeployments(),
                        this.wargamingSystems.get(i).getAllScenarios(), this.wargamingSystems.get(i).getName());
                this.dispose();
            }
            else if(this.buttons.get(i) == clicked && this.furtherModule == ModulesEnum.ROSTER_BUILDER){
                RosterInfoDialog rosterInfoDialog = new RosterInfoDialog(this.wargamingSystems.get(i), new Roster());
                //RosterBuilderWindow rosterBuilderWindow = new RosterBuilderWindow(this.wargamingSystems.get(i));
                this.dispose();
            }
        }
        if(this.backButton == clicked){
            MainMenu mainMenu = new MainMenu();
            this.dispose();
        }
    }
}