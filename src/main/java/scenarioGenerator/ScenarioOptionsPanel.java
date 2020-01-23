package scenarioGenerator;

import javax.swing.*;
import java.awt.*;

public class ScenarioOptionsPanel extends JPanel{
    JLabel titleLabel;

    JSpinner scenariosToGenerateSpinner;

    JCheckBox deploymentDuplicationCheckbox;
    JSpinner deploymentDuplicationQuantitySpinner;

    JCheckBox missionDuplicationCheckbox;
    JSpinner missionDuplicationQuantitySpinner;

    public ScenarioOptionsPanel(){
        super();
        this.titleLabel = new JLabel("Options");

        SpinnerNumberModel universalModel = new SpinnerNumberModel(1, 1, 1000, 1);

        this.scenariosToGenerateSpinner = new JSpinner(universalModel);
        this.deploymentDuplicationCheckbox = new JCheckBox();
        this.deploymentDuplicationQuantitySpinner = new JSpinner(universalModel);
        this.missionDuplicationCheckbox = new JCheckBox();
        this.missionDuplicationQuantitySpinner = new JSpinner(universalModel);

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

        add(this.deploymentDuplicationCheckbox, gbc);
        gbc.gridx++;
        add(this.deploymentDuplicationQuantitySpinner, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        add(this.missionDuplicationCheckbox, gbc);
        gbc.gridx++;
        add(this.missionDuplicationQuantitySpinner, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
    }

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

}
