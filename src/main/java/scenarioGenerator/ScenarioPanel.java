package scenarioGenerator;

import javax.swing.*;
import java.awt.*;

public class ScenarioPanel extends JPanel{
    private JLabel scenarioNameLabel;
    private JLabel deploymentPic;
    private JLabel deploymentLabel;
    private JLabel missionsLabel;
    private JRadioButton choiceRadioButton;

    public ScenarioPanel(Scenario scenario){
        this.scenarioNameLabel = new JLabel(scenario.getName().toUpperCase());
        this.deploymentPic = new JLabel(scenario.getDeployment().getImg());
        this.deploymentLabel = new JLabel("Deployment: " + scenario.getDeployment().getName());
        this.missionsLabel = new JLabel();
        this.choiceRadioButton = new JRadioButton(scenario.getName());

        StringBuilder missions = new StringBuilder("Missions:\n");
        for(Mission mission : scenario.getMissions()){
            missions.append(mission.getName()).append("\n");
        }
        this.missionsLabel.setText(missions.toString());

        this.layoutComponents();
    }

    public void layoutComponents() {
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        add(this.scenarioNameLabel, gbc);
        gbc.gridy++;
        add(this.deploymentPic, gbc);
        gbc.gridy++;
        add(this.deploymentLabel, gbc);
        gbc.gridy++;
        add(this.missionsLabel, gbc);
        gbc.gridy++;
        add(this.choiceRadioButton, gbc);
    }
}
