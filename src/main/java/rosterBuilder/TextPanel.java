package rosterBuilder;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private final JTextArea textArea;

    public TextPanel(){
        textArea = new JTextArea(   15, 10);
        textArea.setLineWrap(true);
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }

    public TextPanel(int rows, int columns){
        textArea = new JTextArea( rows, columns);
        textArea.setLineWrap(true);
        setLayout(new BorderLayout());
        add(new JScrollPane(textArea), BorderLayout.CENTER);

    }
    public void appendText(String text){
        textArea.append(text);
    }
}
