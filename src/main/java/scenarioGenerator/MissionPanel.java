package scenarioGenerator;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MissionPanel extends JPanel {
    private JLabel label;
    private ArrayList<JRadioButton> radioButtons;

    public MissionPanel(MissionList missions){
        super();
        this.label = new JLabel(missions.getName() + ":");
        this.radioButtons = new ArrayList<>();
        for(int i=0; i<missions.size(); i++) {
            Mission mission = missions.get(i);
            JRadioButton radioButton = new JRadioButton(mission.getName());
            this.radioButtons.add(radioButton);
            radioButton.setSelected(true);
        }
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        if(this.radioButtons.size() <= 3){
            gbc.gridx = this.radioButtons.size()/2;
        }
        else{
            gbc.gridx = 1;
        }
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        add(this.label, gbc);
        gbc.gridy++;
        gbc.gridx = 0;
        for(int i=0; i< this.radioButtons.size(); i++){
            if(i%3 == 0 && i != 0){
                gbc.gridx = 0;
                gbc.gridy++;
            }
            add(this.radioButtons.get(i), gbc);
            gbc.gridx++;
        }
    }

    public ArrayList<Boolean> getChosenData(){
        ArrayList<Boolean> data = new ArrayList<>();
        for (JRadioButton radioButton : this.radioButtons) {
            boolean isChosen = radioButton.isSelected();
            data.add(isChosen);
        }
        return data;
    }
}