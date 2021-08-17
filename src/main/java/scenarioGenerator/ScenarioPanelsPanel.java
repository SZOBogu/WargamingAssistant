package scenarioGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ScenarioPanelsPanel extends JPanel {
    private List<ScenarioPanel> scenarioPanels;

    public ScenarioPanelsPanel(List<Scenario> scenarios){
        this.scenarioPanels = new ArrayList<>();
        for(Scenario scenario : scenarios){
            this.scenarioPanels.add(new ScenarioPanel(scenario));
        }
        this.layoutComponenets();
    }

    private void layoutComponenets(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.fill = GridBagConstraints.NONE;
        for(int i=0; i< this.scenarioPanels.size(); i++) {
            if(i%3 == 0 && i != 0){
                gbc.gridx = 0;
                gbc.gridy++;
            }
            add(this.scenarioPanels.get(i), gbc);
            gbc.gridx++;
        }
    }
}
