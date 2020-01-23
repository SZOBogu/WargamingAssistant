package scenarioGenerator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScenarioDisplayer extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private JLabel deploymentNameLabel;
    private JLabel deploymentImageLabel;
    private ArrayList<JLabel> scenarioNamesLabel;
    private ArrayList<JLabel> scenarioDescriptionsLabel;
    private JButton disposeButton;

    public ScenarioDisplayer(Deployment deployment, ArrayList<Mission> missions){
        super();
        this.titleLabel = new JLabel("Scenario Generator");
        this.deploymentNameLabel = new JLabel(deployment.getName());
        this.deploymentImageLabel = new JLabel(deployment.getImg());
        this.scenarioNamesLabel = new ArrayList<>();
        this.scenarioDescriptionsLabel = new ArrayList<>();
        this.disposeButton = new JButton("Go Back");
        this.disposeButton.addActionListener(this);

        for(int i = 0; i< missions.size(); i++){
            this.scenarioNamesLabel.add(new JLabel(missions.get(i).getName()));
            this.scenarioDescriptionsLabel.add(new JLabel(missions.get(i).getDescription()));
        }

        setMinimumSize(new Dimension(1000, 800));
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridwidth = 0;

        add(this.titleLabel, gbc);
        gbc.gridy++;
        add(this.deploymentNameLabel, gbc);
        gbc.gridy++;
        add(this.deploymentImageLabel, gbc);
        gbc.gridy++;
        for(int i=0;i<this.scenarioNamesLabel.size();i++){
            add(this.scenarioNamesLabel.get(i), gbc);
            gbc.gridy++;
            add(this.scenarioDescriptionsLabel.get(i), gbc);
            gbc.gridy++;
        }
        add(this.disposeButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dispose();
    }
}