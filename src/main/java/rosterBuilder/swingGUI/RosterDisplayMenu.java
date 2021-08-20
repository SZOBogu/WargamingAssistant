package rosterBuilder.swingGUI;

import rosterBuilder.Roster;
import rosterBuilder.RosterSummarizer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RosterDisplayMenu extends JFrame implements ActionListener {
    private JButton backButton;
    private JButton exportButton;
    private TextPanel rosterTextArea;
    String displayedText;

    public RosterDisplayMenu(Roster roster){
        this.rosterTextArea = new TextPanel(40, 50);
        RosterSummarizer rosterSummarizer = new RosterSummarizer();
        this.displayedText = roster.toString() + "\n\n" + rosterSummarizer.summarize(roster);
        this.rosterTextArea.appendText(displayedText);

        this.backButton = new JButton("Go Back");
        this.backButton.addActionListener(this);
        this.exportButton = new JButton("Export to file");
        this.exportButton.addActionListener(this);
        setMinimumSize(new Dimension(800, 600));
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.layoutComponents();
    }

    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 0;
        gbc.gridx = 0;

        add(this.rosterTextArea, gbc);
        gbc.gridy++;
        add(this.backButton, gbc);
        gbc.gridy++;
        add(this.exportButton, gbc);
    }


    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        JButton clicked = (JButton)actionEvent.getSource();
        if(this.exportButton == clicked) {
            BufferedWriter writer = null;
            try {
                int i = 0;
                String filename = Integer.toString(i);
                File f = new File(filename);
                while (f.exists()) {
                    i++;
                    filename = Integer.toString(i);
                    f = new File("roster" + filename);
                }
                FileWriter fw = new FileWriter(f);
                fw.write(displayedText);
                JOptionPane.showMessageDialog(new JFrame(), "Roster exported to file: " + f.getName(),
                        "Roster Export Successful", JOptionPane.OK_OPTION);
                if(writer != null)
                    writer.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                 }
        }
        else if(this.backButton == clicked){
            this.dispose();
        }
    }
}
