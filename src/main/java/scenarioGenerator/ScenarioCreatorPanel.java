//package scenarioGenerator;
//
//import common.ModulesEnum;
//import common.RandomArrayElementsGetter;
//import common.SystemSelectionMenu;
//import rosterBuilder.WargameSystemsInitializer;
//import rosterBuilder.WargamingSystem;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//import java.util.ArrayList;
//import java.util.Collections;
//
//public class ScenarioCreatorPanel extends JPanel implements ActionListener {
//    private JLabel titleLabel;
//    private JLabel missionLabel;
//    private JLabel deploymentLabel;
//    private ScenarioOptionsPanel scenarioOptionsPanel;
//    private DeploymentPanel deploymentPanel;
//    private MissionPanelsPanel missionPanel;
//    private ScenarioPanelsPanel scenarioPanelsPanel;
//    private JButton backButton;
//    private JButton runButton;
//
//    private List<Deployment> deployments;
//    private List<MissionList> missionLists;
//
//    public ScenarioCreatorPanel(List<Scenario> scenarios, List<Deployment> deployments,
//                                List<MissionList> missionLists, String systemName){
//        this.deployments = deployments;
//        this.missionLists = missionLists;
//
//        this.titleLabel = new JLabel("Scenario Generator for " + systemName);
//        this.missionLabel = new JLabel("Choose Scenarios that generator should randomly choose from:");
//        this.deploymentLabel = new JLabel("Choose Deployments that generator should randomly choose from:");
//        this.scenarioOptionsPanel = new ScenarioOptionsPanel();
//        this.deploymentPanel = new DeploymentPanel(deployments);
//        this.missionPanel = new MissionPanelsPanel(missionLists);
//        this.scenarioPanelsPanel = new ScenarioPanelsPanel(scenarios);
//        this.runButton = new JButton("Generate Scenario");
//        this.backButton = new JButton("Go Back");
//        this.runButton.addActionListener(this);
//        this.backButton.addActionListener(this);
//        this.layoutComponents();
//    }
//
//    private void layoutComponents(){
//        this.setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.gridwidth = 0;
//        gbc.fill = GridBagConstraints.NONE;
//        gbc.anchor = GridBagConstraints.CENTER;
//
//        add(this.titleLabel,gbc);
//        gbc.gridy++;
//        add(this.scenarioOptionsPanel, gbc);
//        gbc.gridy++;
//        add(this.deploymentLabel, gbc);
//        gbc.gridy++;
//        add(this.deploymentPanel, gbc);
//        gbc.gridy++;
//        add(this.missionLabel, gbc);
//        gbc.gridy++;
//        add(this.missionPanel, gbc);
//        gbc.gridy++;
//        add(backButton, gbc);
//        gbc.gridy++;
//        add(runButton, gbc);
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent actionEvent){
//        JButton clicked = (JButton)actionEvent.getSource();
//        if(clicked == runButton) {
//            boolean isDeploymentsChosen = false;
//            for(int i = 0; i < this.deploymentPanel.getChosenData().size(); i++){
//                if(this.deploymentPanel.getChosenData().get(i)){
//                    isDeploymentsChosen = true;
//                    break;
//                }
//            }
//            boolean isScenariosChosen = false;
//            for(int i = 0; i < this.missionPanel.getChosenData().size(); i++){
//                for(int j = 0; j < this.missionPanel.getChosenData().get(i).size(); j++){
//                    if(this.missionPanel.getChosenData().get(i).get(j)) {
//                        isScenariosChosen = true;
//                        break;
//                    }
//                }
//            }
//            //TODO:obsługa scenario with deploymentów
//            if(!isDeploymentsChosen && !isScenariosChosen) {
//                JOptionPane.showMessageDialog(new JFrame(), "You haven't picked anything", "Dialog",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//            else if(isDeploymentsChosen && !isScenariosChosen){
//                JOptionPane.showMessageDialog(new JFrame(), "You haven't picked scenario", "Dialog",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//            else if(!isDeploymentsChosen){
//                JOptionPane.showMessageDialog(new JFrame(), "You haven't picked deployment", "Dialog",
//                        JOptionPane.ERROR_MESSAGE);
//            }
//            else {
//                List<List<Boolean>> scenarioBooleans = this.missionPanel.getChosenData();
//                List<Integer> allFalseArraysIndexes = new ArrayList<>();
//                //TODO: do osobnego obiektu
//                for (int i = 0; i < scenarioBooleans.size(); i++) {
//                    boolean isArrayAllFalse = true;
//                    for (int j = 0; j < scenarioBooleans.get(i).size(); j++) {
//                        if (scenarioBooleans.get(i).get(j)) {
//                            isArrayAllFalse = false;
//                            break;
//                        }
//                    }
//                    if (isArrayAllFalse)
//                        allFalseArraysIndexes.add(i);
//                }
//                Collections.reverse(allFalseArraysIndexes);
//
//                for (Integer allFalseArraysIndex : allFalseArraysIndexes) {
//                    scenarioBooleans.remove((int) allFalseArraysIndex);
//                }
//                boolean anyRepsM = scenarioOptionsPanel.getAnyNumberOfDuplicateMissions();
//                boolean canRepM = scenarioOptionsPanel.getCanDuplicateMissions();
//
//                boolean anyRepsD = scenarioOptionsPanel.getAnyNumberOfDuplicateDeployments();
//                boolean canRepD = scenarioOptionsPanel.getCanDuplicateDeployments();
//
//                List<Deployment> randomDeployments;
//                List<List<Mission>> randomMissionsPack = new ArrayList<>();
//
//                List<Integer> chosenDeploymentIndexes = BoolListToIndexListConverter.convert(this.deploymentPanel.getChosenData());
//                List<Deployment> chosenDeploymentPool = new ArrayList<>();
//                for (Integer chosenDeploymentIndex : chosenDeploymentIndexes) {
//                    chosenDeploymentPool.add(this.deployments.get(chosenDeploymentIndex));
//                }
//                List<List<Integer>> chosenMissionsIndexes = BoolListToIndexListConverter.convert2dList(this.missionPanel.getChosenData());
//                List<List<Mission>> chosenMissions = new ArrayList<>();
//
//                for (int i = 0; i < chosenMissionsIndexes.size(); i++) {
//                    chosenMissions.add(new ArrayList<>());
//                    for (int j = 0; j < chosenMissionsIndexes.get(i).size(); j++) {
//                        chosenMissions.get(i).add(this.missionLists.get(i).get(j));
//                    }
//                }
//
//                if (ScenarioFormValidator.canBeGenerated(chosenDeploymentPool, chosenMissions,
//                        this.scenarioOptionsPanel.getDuplicateDeploymentsQuantity(), this.scenarioOptionsPanel.getDuplicateMissionsQuantity(),
//                        this.scenarioOptionsPanel.getScenarioToGenerateCount())) {
//                    if (canRepD) {
//                        if (anyRepsD) {
//                            randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithAnyReps(chosenDeploymentPool,
//                                    this.scenarioOptionsPanel.getScenarioToGenerateCount());
//                        } else {
//                            randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithReps(chosenDeploymentPool,
//                                    this.scenarioOptionsPanel.getDuplicateDeploymentsQuantity(),
//                                    this.scenarioOptionsPanel.getScenarioToGenerateCount());
//                        }
//                    }
//                    else
//                        randomDeployments = RandomArrayElementsGetter.randomArrayElementsWithoutReps(chosenDeploymentPool, this.scenarioOptionsPanel.getScenarioToGenerateCount());
//
//                    if (canRepM) {
//                        if (anyRepsM) {
//                            for (int i = 0; i < chosenMissionsIndexes.size(); i++) {
//                                randomMissionsPack.add(RandomArrayElementsGetter.randomArrayElementsWithAnyReps(chosenMissions.get(i),
//                                        this.scenarioOptionsPanel.getScenarioToGenerateCount()));
//                            }
//                        } else {
//                            for (List<Mission> chosenMission : chosenMissions) {
//                                randomMissionsPack.add(RandomArrayElementsGetter.randomArrayElementsWithReps(chosenMission,
//                                        this.scenarioOptionsPanel.getDuplicateMissionsQuantity(),
//                                        this.scenarioOptionsPanel.getScenarioToGenerateCount()));
//                            }
//                        }
//                    } else {
//                        for (List<Mission> chosenMission : chosenMissions) {
//                            randomMissionsPack.add(RandomArrayElementsGetter.randomArrayElementsWithoutReps(chosenMission,
//                                    this.scenarioOptionsPanel.getScenarioToGenerateCount()));
//                        }
//                    }
//                ScenarioDisplayer scenarioDisplayer = new ScenarioDisplayer(randomDeployments, randomMissionsPack);
//            }
//            else
//                JOptionPane.showMessageDialog(new JFrame(),
//                        "Too few missions and/or deployments chosen to generate that number of scenarios"
//                        , "Dialog", JOptionPane.ERROR_MESSAGE);
//            }
//        }
//        else if(clicked == backButton){
//            WargameSystemsInitializer init = new WargameSystemsInitializer();
//            List<WargamingSystem> wargamingSystems = init.initialize();
//            SystemSelectionMenu systemSelectionMenu = new SystemSelectionMenu(
//                    wargamingSystems, ModulesEnum.SCENARIO_CREATOR);
//            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
//            topFrame.dispose();
//        }
//    }
//}
