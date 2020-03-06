package scenarioGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MissionPanelsPanel extends JPanel {
    private ArrayList<MissionPanel> panels;

    public MissionPanelsPanel(ArrayList<MissionList> scenarios){
        this.panels = new ArrayList<>();
        for (MissionList scenario : scenarios) {
            panels.add(new MissionPanel(scenario));
        }
        this.layoutComponents();
    }

    private void layoutComponents(){
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 0;
        gbc.fill = GridBagConstraints.NONE;
        for (MissionPanel panel : this.panels) {
            add(panel, gbc);
            gbc.gridy++;
        }
    }

    public ArrayList<ArrayList<Boolean>> getChosenData(){
        ArrayList<ArrayList<Boolean>> data = new ArrayList<>();
        for (MissionPanel panel : this.panels) {
            data.add(panel.getChosenData());
        }
        return data;
    }
}
