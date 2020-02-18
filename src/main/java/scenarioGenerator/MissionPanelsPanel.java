package scenarioGenerator;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MissionPanelsPanel extends JPanel {
    private ArrayList<MissionPanel> panels;

    public MissionPanelsPanel(ArrayList<MissionList> scenarios){
        this.panels = new ArrayList<>();
        for(int i=0;i<scenarios.size();i++){
            panels.add(new MissionPanel(scenarios.get(i)));
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
        for(int i=0; i<this.panels.size();i++){
            add(this.panels.get(i), gbc);
            gbc.gridy++;
        }
    }

    public ArrayList<ArrayList<Boolean>> getChosenData(){
        ArrayList<ArrayList<Boolean>> data = new ArrayList<>();
        for(int i=0; i < this.panels.size(); i++){
            data.add(this.panels.get(i).getChosenData());
        }
        return data;
    }
}
