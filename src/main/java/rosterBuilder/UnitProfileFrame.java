package rosterBuilder;

import javax.swing.*;
import java.awt.*;

public class UnitProfileFrame extends JFrame{
    private UnitProfilePanel unitProfilePanel;

    public UnitProfileFrame(UnitProfile unitProfile, Roster roster, DetachmentPanel detachmentPanel, int detNumber, int categoryNumber, WargamingSystem wargamingSystem){
        super(unitProfile.getName() + " - Unit Creator");
        this.unitProfilePanel = new UnitProfilePanel(unitProfile, roster, detachmentPanel, detNumber, categoryNumber, wargamingSystem);
        setLayout(new BorderLayout());
        add(new JScrollPane(this.unitProfilePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        setMinimumSize(new Dimension(800, 600));
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
