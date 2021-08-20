//package scenarioGenerator;
//
//import javax.swing.*;
//import java.awt.*;
//import java.util.ArrayList;
//import java.util.List;
//
//public class GeneratedScenarioPanel extends JPanel {
//    private JLabel deploymentNameLabel;
//    private JLabel deploymentImageLabel;
//    private List<JLabel> scenarioNamesLabel;
//    private List<JLabel> scenarioDescriptionsLabel;
//
//    public GeneratedScenarioPanel(Deployment deployment, List<Mission> missions){
//        super();
//        this.deploymentNameLabel = new JLabel(deployment.getName());
//        this.deploymentImageLabel = new JLabel(deployment.getEncodedImage());
//        this.scenarioNamesLabel = new ArrayList<>();
//        this.scenarioDescriptionsLabel = new ArrayList<>();
//
//        for (Mission mission : missions) {
//            this.scenarioNamesLabel.add(new JLabel(mission.getName()));
//            this.scenarioDescriptionsLabel.add(new JLabel(mission.getDescription()));
//        }
//        this.layoutComponents();
//    }
//
//    private void layoutComponents(){
//        setLayout(new GridBagLayout());
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = 0;
//        gbc.gridy = 0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//        gbc.anchor = GridBagConstraints.CENTER;
//        gbc.gridwidth = 0;
//
//        add(this.deploymentNameLabel, gbc);
//        gbc.gridy++;
//        add(this.deploymentImageLabel, gbc);
//        gbc.gridy++;
//        for(int i=0;i<this.scenarioNamesLabel.size();i++){
//            add(this.scenarioNamesLabel.get(i), gbc);
//            gbc.gridy++;
//            add(this.scenarioDescriptionsLabel.get(i), gbc);
//            gbc.gridy++;
//        }
//    }
//}