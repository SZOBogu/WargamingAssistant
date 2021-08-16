package scenarioGenerator;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DeploymentPanel extends JPanel {
    private JLabel titleLabel;
    private ArrayList<JLabel> labels;
    private ArrayList<JRadioButton> radioButtons;

    public DeploymentPanel(ArrayList<Deployment> deployments){
        super();
        this.titleLabel = new JLabel("Deployments:");
        this.labels = new ArrayList<>();
        this.radioButtons = new ArrayList<>();

        for(int i=0;i<deployments.size();i++){
            JLabel label = new JLabel(deployments.get(i).getEncodedImage());
            JRadioButton radioButton = new JRadioButton(deployments.get(i).getName());

            this.labels.add(label);
            this.radioButtons.add(radioButton);
            radioButton.setSelected(true);
        }
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(this.titleLabel, gbc);
        gbc.gridy++;
        gbc.gridx = 0;

        for(int i=0; i<this.labels.size(); i++){
            if(i%3 == 0 && i != 0){
                gbc.gridx = 0;
                gbc.gridy+=2;
            }
            add(this.labels.get(i), gbc);
            gbc.gridy++;
            add(this.radioButtons.get(i), gbc);
            gbc.gridy--;
            gbc.gridx++;
        }
    }

    public ArrayList<Boolean> getChosenData(){
        ArrayList<Boolean> data = new ArrayList<>();
        for(int i=0; i < this.radioButtons.size(); i++){
            boolean isChosen = this.radioButtons.get(i).isSelected();
            data.add(isChosen);
        }
        return data;
    }
}
