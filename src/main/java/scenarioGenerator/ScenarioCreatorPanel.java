package scenarioGenerator;

import common.ModulesEnum;
import common.SystemSelectionMenu;
import rosterBuilder.WargameSystemsInitializer;
import rosterBuilder.WargamingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class ScenarioCreatorPanel extends JPanel implements ActionListener {
    private JLabel titleLabel;
    private JLabel scenLabel;
    private JLabel deploymentLabel;
    private ScenarioOptionsPanel scenarioOptionsPanel;
    private DeploymentPanel deploymentPanel;
    private MissionPanelsPanel scenarioPanel;
    private JButton backButton;
    private JButton runButton;

    private ArrayList<Deployment> deployments;
    private ArrayList<MissionList> scenarios;

    public ScenarioCreatorPanel(ArrayList<Deployment> deployments, ArrayList<MissionList> scenarios, String systemName){
        this.deployments = deployments;
        this.scenarios = scenarios;

        this.titleLabel = new JLabel("Scenario Generator for " + systemName);
        this.scenLabel = new JLabel("Choose Scenarios that generator should randomly choose from:");
        this.deploymentLabel = new JLabel("Choose Deployments that generator should randomly choose from:");
        this.scenarioOptionsPanel = new ScenarioOptionsPanel();
        this.deploymentPanel = new DeploymentPanel(deployments);
        this.scenarioPanel = new MissionPanelsPanel(scenarios);
        this.runButton = new JButton("Generate Scenario");
        this.backButton = new JButton("Go Back");
        this.runButton.addActionListener(this);
        this.backButton.addActionListener(this);
        this.layoutComponents();
    }

    private void layoutComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        add(this.titleLabel,gbc);
        gbc.gridy++;
        add(this.scenarioOptionsPanel, gbc);
        gbc.gridy++;
        add(this.deploymentLabel, gbc);
        gbc.gridy++;
        add(this.deploymentPanel, gbc);
        gbc.gridy++;
        add(this.scenLabel, gbc);
        gbc.gridy++;
        add(this.scenarioPanel, gbc);
        gbc.gridy++;
        add(backButton, gbc);
        gbc.gridy++;
        add(runButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        JButton clicked = (JButton)actionEvent.getSource();
        if(clicked == runButton) {
            RandomDeploymentGetter deploymentGetter = new RandomDeploymentGetter();
            RandomScenariosGetter scenariosGetter = new RandomScenariosGetter();

            boolean isDeploymentsChosen = false;
            for(int i = 0; i < this.deploymentPanel.getChosenData().size(); i++){
                if(this.deploymentPanel.getChosenData().get(i)){
                    isDeploymentsChosen = true;
                    break;
                }
            }
            boolean isScenariosChosen = false;
            for(int i = 0; i < this.scenarioPanel.getChosenData().size(); i++){
                for(int j = 0; j < this.scenarioPanel.getChosenData().get(i).size(); j++){
                    if(this.scenarioPanel.getChosenData().get(i).get(j)) {
                        isScenariosChosen = true;
                        break;
                    }
                }
            }
            //TODO:obsługa scenario with deploymentów
            if(!isDeploymentsChosen && !isScenariosChosen) {
                JOptionPane.showMessageDialog(new JFrame(), "You haven't picked anything", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(isDeploymentsChosen && !isScenariosChosen){
                JOptionPane.showMessageDialog(new JFrame(), "You haven't picked scenario", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
            else if(!isDeploymentsChosen){
                JOptionPane.showMessageDialog(new JFrame(), "You haven't picked deployment", "Dialog",
                        JOptionPane.ERROR_MESSAGE);
            }
            else{
                ArrayList<ArrayList<Boolean>> scenarioBooleans = this.scenarioPanel.getChosenData();
                ArrayList<Integer> allFalseArraysIndexes = new ArrayList<>();
                //TODO: do osobnego obiektu
                for(int i = 0; i < scenarioBooleans.size(); i++) {
                    boolean isArrayAllFalse = true;
                    for (int j = 0; j < scenarioBooleans.get(i).size(); j++) {
                        if(scenarioBooleans.get(i).get(j))
                            isArrayAllFalse = false;
                    }
                    if(isArrayAllFalse)
                        allFalseArraysIndexes.add(i);
                }
                Collections.reverse(allFalseArraysIndexes);

                for(int i = 0; i < allFalseArraysIndexes.size(); i++) {
                    scenarioBooleans.remove((int)allFalseArraysIndexes.get(i));
                }
                Deployment randomDeployment = deploymentGetter.getDeployment(this.deployments , this.deploymentPanel.getChosenData());
                ArrayList<Mission> randomMissions = scenariosGetter.getScenarios(this.scenarios, scenarioBooleans);

                if (!randomMissions.isEmpty() && randomMissions.get(0).getDeployment() != null) {
                    for (int i = 0; i < randomMissions.size(); i++) {
                        randomDeployment = randomMissions.get(i).getDeployment();
                    }
                }
                ScenarioDisplayer scenarioDisplayer = new ScenarioDisplayer(randomDeployment, randomMissions);
            }
        }
        else if(clicked == backButton){
            WargameSystemsInitializer init = new WargameSystemsInitializer();
            ArrayList<WargamingSystem> wargamingSystems = init.initialize();
            SystemSelectionMenu systemSelectionMenu = new SystemSelectionMenu(wargamingSystems, ModulesEnum.SCENARIO_CREATOR);
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
    }
}
