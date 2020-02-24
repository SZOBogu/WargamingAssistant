package scenarioGenerator;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScenarioCreator extends JFrame {
    private ScenarioCreatorPanel panel;

    public ScenarioCreator(ArrayList<Deployment> deployments, ArrayList<MissionList> missions, String systemName){
        this.panel = new ScenarioCreatorPanel(deployments, missions, systemName);
        setLayout(new BorderLayout());
        add(new JScrollPane(this.panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        setMinimumSize(new Dimension(1000, 600));
        setSize(1000, 1800);
        setMaximumSize(new Dimension(1000, 1800));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }
}
