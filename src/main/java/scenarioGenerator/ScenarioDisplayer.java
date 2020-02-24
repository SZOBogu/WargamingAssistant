package scenarioGenerator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ScenarioDisplayer extends JFrame implements ActionListener {
    private JLabel titleLabel;
    private ArrayList<GeneratedScenarioPanel> scenarioPanels;
    private JButton disposeButton;

    public ScenarioDisplayer(ArrayList<Deployment> deployments, ArrayList<ArrayList<Mission>> missions){
        super();
        this.titleLabel = new JLabel("Scenario Generator");
        this.disposeButton = new JButton("Go Back");
        this.disposeButton.addActionListener(this);
        this.scenarioPanels = new ArrayList<>();

        int size = 0;
        //TODO: look into suspiciously disappearing missions
        if (missions.size() > deployments.size())
            size = deployments.size();
        else
            size = missions.size();
        for(int i = 0; i < size; i++){
            scenarioPanels.add(new GeneratedScenarioPanel(deployments.get(i), missions.get(i)));
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

        for(int i=0;i<this.scenarioPanels.size();i++){
            add(this.scenarioPanels.get(i), gbc);
            gbc.gridy++;
        }

        add(this.disposeButton, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.dispose();
    }
}