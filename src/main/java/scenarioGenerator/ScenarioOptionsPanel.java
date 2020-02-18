package scenarioGenerator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ScenarioOptionsPanel extends JPanel{
    private JLabel titleLabel;

    private JSpinner scenariosToGenerateSpinner;
    private JLabel scenariosToGenerateLabel;

    private JCheckBox deploymentDuplicationCheckbox;
    private JSpinner deploymentDuplicationQuantitySpinner;

    private JCheckBox missionDuplicationCheckbox;
    private JSpinner missionDuplicationQuantitySpinner;

    private JCheckBox anyNumberOfDeploymentDuplicationCheckbox;
    private JCheckBox anyNumberOfMissionDuplicationCheckbox;

    public ScenarioOptionsPanel(){
        super();
        this.titleLabel = new JLabel("Options");
        this.scenariosToGenerateLabel = new JLabel("How many Scearios would you like to generate?");
        SpinnerNumberModel universalModel = new SpinnerNumberModel(5, 1, 1000, 1);

        this.scenariosToGenerateSpinner = new JSpinner(universalModel);
        this.deploymentDuplicationQuantitySpinner = new JSpinner(universalModel);
        deploymentDuplicationQuantitySpinner.setEnabled(false);
        this.missionDuplicationQuantitySpinner = new JSpinner(universalModel);
        missionDuplicationQuantitySpinner.setEnabled(false);

        this.deploymentDuplicationCheckbox = new JCheckBox("Duplicate Deployments?");
        this.deploymentDuplicationCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                    deploymentDuplicationQuantitySpinner.setEnabled(true);
                }
                else if(itemEvent.getStateChange() == ItemEvent.DESELECTED){
                    deploymentDuplicationQuantitySpinner.setEnabled(false);
                }
                validate();
                repaint();
            }
        });

        this.missionDuplicationCheckbox = new JCheckBox("Duplicate missions?");
        this.missionDuplicationCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                    missionDuplicationQuantitySpinner.setEnabled(true);
                }
                else if(itemEvent.getStateChange() == ItemEvent.DESELECTED){
                    missionDuplicationQuantitySpinner.setEnabled(false);
                }
                validate();
                repaint();
            }
        });

        this.anyNumberOfDeploymentDuplicationCheckbox = new JCheckBox("Any Number");
        this.anyNumberOfDeploymentDuplicationCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                    deploymentDuplicationQuantitySpinner.setEnabled(false);
                }
                else if(itemEvent.getStateChange() == ItemEvent.DESELECTED  && deploymentDuplicationCheckbox.isSelected()){
                    deploymentDuplicationQuantitySpinner.setEnabled(true);
                }
                validate();
                repaint();
            }
        });

        this.anyNumberOfMissionDuplicationCheckbox = new JCheckBox("Any Number");
        this.anyNumberOfMissionDuplicationCheckbox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if(itemEvent.getStateChange() == ItemEvent.SELECTED){
                    missionDuplicationQuantitySpinner.setEnabled(false);
                }
                else if(itemEvent.getStateChange() == ItemEvent.DESELECTED  && missionDuplicationCheckbox.isSelected()){
                    missionDuplicationQuantitySpinner.setEnabled(true);
                }
                validate();
                repaint();
            }
        });
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        add(titleLabel, gbc);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        gbc.gridy++;
        add(scenariosToGenerateLabel, gbc);
        gbc.gridx++;
        add(scenariosToGenerateSpinner, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        add(this.deploymentDuplicationCheckbox, gbc);
        gbc.gridx++;
        add(this.anyNumberOfDeploymentDuplicationCheckbox, gbc);
        gbc.gridx++;
        add(this.deploymentDuplicationQuantitySpinner, gbc);
        gbc.gridy++;

        gbc.gridx = 0;

        add(this.missionDuplicationCheckbox, gbc);
        gbc.gridx++;
        add(this.anyNumberOfMissionDuplicationCheckbox, gbc);
        gbc.gridx++;
        add(this.missionDuplicationQuantitySpinner, gbc);
        gbc.gridy++;

        gbc.gridx = 0;
    }
    public int getScenarioToGenerateCount(){return (int)this.scenariosToGenerateSpinner.getValue();}

    public boolean getCanDuplicateDeployments(){
        return this.deploymentDuplicationCheckbox.isSelected();
    }

    public int getDuplicateDeploymentsQuantity(){
        return (int)this.deploymentDuplicationQuantitySpinner.getValue();
    }

    public boolean getCanDuplicateMissions(){
        return this.missionDuplicationCheckbox.isSelected();
    }

    public int getDuplicateMissionsQuantity(){
        return (int)this.missionDuplicationQuantitySpinner.getValue();
    }

    public boolean getAnyNumberOfDuplicateDeployments(){
        return this.anyNumberOfDeploymentDuplicationCheckbox.isSelected();
    }

    public boolean getAnyNumberOfDuplicateMissions(){
        return this.anyNumberOfMissionDuplicationCheckbox.isSelected();
    }
}
