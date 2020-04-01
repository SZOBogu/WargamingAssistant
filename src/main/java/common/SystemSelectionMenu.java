package common;

import rosterBuilder.Roster;
import rosterBuilder.RosterInfoDialog;
import rosterBuilder.RosterObserverSubject;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.ScenarioCreatorFrame;

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
        for (WargamingSystem wargamingSystem : wargamingSystems) {
            JButton button = new JButton(wargamingSystem.getName());
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

        for (JButton button : this.buttons) {
            add(button, gbc);
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
                new ScenarioCreatorFrame(this.wargamingSystems.get(i).getScenarios(),
                        this.wargamingSystems.get(i).getDeployments(),
                        this.wargamingSystems.get(i).getAllMissions(),
                        this.wargamingSystems.get(i).getName());
                this.dispose();
            }
            else if(this.buttons.get(i) == clicked && this.furtherModule == ModulesEnum.ROSTER_BUILDER){
                RosterObserverSubject rosterObserverSubject  = new RosterObserverSubject();
                Roster roster = new Roster();
                rosterObserverSubject.setRoster(roster);
                new RosterInfoDialog(this.wargamingSystems.get(i), rosterObserverSubject);
                this.dispose();
            }
        }
        if(this.backButton == clicked){
            new MainMenu();
            this.dispose();
        }
    }
}