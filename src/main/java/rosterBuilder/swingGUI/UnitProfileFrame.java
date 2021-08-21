package rosterBuilder.swingGUI;

import rosterBuilder.RosterObserverSubject;
import rosterBuilder.UnitProfile;
import rosterBuilder.WargamingSystem;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class UnitProfileFrame extends JFrame{
    private UnitProfilePanel unitProfilePanel;

    public UnitProfileFrame(UnitProfile unitProfile, RosterObserverSubject roster,
                            DetachmentPanel detachmentPanel, int detNumber, int categoryNumber,
                            WargamingSystem wargamingSystem){

        super(unitProfile.getName() + " - Unit Creator");
        this.unitProfilePanel = new UnitProfilePanel(unitProfile, roster,
                detachmentPanel, detNumber, categoryNumber, wargamingSystem);
        setLayout(new BorderLayout());
        add(new JScrollPane(this.unitProfilePanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED), BorderLayout.CENTER);
        setMinimumSize(new Dimension(800, 600));
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public UnitProfileFrame(UnitProfile unitProfile, RosterObserverSubject roster,
                            DetachmentPanel detachmentPanel, int detNumber, int categoryNumber,
                            WargamingSystem wargamingSystem, List<List<Integer>> indexesToSelect){

        this(unitProfile, roster, detachmentPanel, detNumber, categoryNumber, wargamingSystem);
        this.unitProfilePanel = new UnitProfilePanel(unitProfile, roster, detachmentPanel,
                detNumber, categoryNumber, wargamingSystem, indexesToSelect);
    }
}
