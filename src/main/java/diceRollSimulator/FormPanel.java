package diceRollSimulator;

import common.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel implements ActionListener {
    private JLabel titleLabel;
    private JLabel diceQuantityLabel;
    private JLabel diceRollSuccessfulResultLabel;
    private JLabel rerollLabel;
    private JLabel specificResultRerollLabel;
    private JLabel diceSidesLabel;
    private JLabel countFailuresLabel;

    private JSpinner diceQuantitySpinner;
    private JSpinner diceRollSuccessfulResultSpinner;
    private JSpinner diceSidesSpinner;
    private JSpinner specificResultRerollSpinner;

    private JCheckBox rerollCheckBox;
    private JCheckBox countFailuresCheckbox;

    private JButton addDiceRollButton;
    private JButton clearButton;
    private JButton backButton;
    private JButton helpButton;
    private JButton randomButton;
    private JButton nonRandomButton;

    private FormListener formListener;
   // private StringListener stringListener;
    private ClearListener clearListener;
    private RunListener runListener;
    private NonRandomRunListener nonRandomRunListener;

    public FormPanel(){
        this.titleLabel = new JLabel(" common.Dice Roll Simulator Menu");
        this.diceQuantityLabel = new JLabel("How many dices?");
        this.diceRollSuccessfulResultLabel = new JLabel("Minimal result to succeed?");
        this.rerollLabel = new JLabel("Re Roll (Default: failures)");
        this.rerollCheckBox = new JCheckBox();
        this.specificResultRerollLabel = new JLabel("Re Roll only specific result");
        this.diceSidesLabel = new JLabel("How many sides should dice have?");
        this.countFailuresLabel = new JLabel("Count failures instead of successes?(simulates enemy roll)");
        this.countFailuresCheckbox = new JCheckBox();

        SpinnerNumberModel diceSidesModel = new SpinnerNumberModel(6, 2, 1000, 1);
        this.diceSidesSpinner= new JSpinner(diceSidesModel);

        SpinnerNumberModel quantityModel = new SpinnerNumberModel(1, 1, 1000, 1);
        this.diceQuantitySpinner = new JSpinner(quantityModel);

        SpinnerNumberModel successModel = new SpinnerNumberModel(2, 2, (int)this.diceSidesSpinner.getValue(), 1);
        this.diceRollSuccessfulResultSpinner = new JSpinner(successModel);

        SpinnerNumberModel valueToReRollModel = new SpinnerNumberModel(-1, -1, 1000, 1);
        this.specificResultRerollSpinner = new JSpinner(valueToReRollModel);

        this.addDiceRollButton = new JButton("Add dice roll to simulation");
        this.addDiceRollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int quantity = (int)diceQuantitySpinner.getValue();
                int successValue = (int)diceRollSuccessfulResultSpinner.getValue();
                boolean reroll = rerollCheckBox.isSelected();
                int valueToReRoll = (int)specificResultRerollSpinner.getValue();
                boolean failures = countFailuresCheckbox.isSelected();
                int diceSides = (int)diceSidesSpinner.getValue();

                SpinnerNumberModel valueToReRollModel = new SpinnerNumberModel(-1, -1, (int)diceSidesSpinner.getValue(), 1);
                specificResultRerollSpinner = new JSpinner(valueToReRollModel);

                FormEvent event = new FormEvent(this, quantity, successValue, reroll, failures, diceSides, valueToReRoll);

                if (formListener != null){
                    formListener.formEventOccurred(event);
                }
            }
        });

        this.clearButton = new JButton("Clear all dice rolls");
        this.clearButton.addActionListener(this);

        this.helpButton = new JButton("Help");
        this.helpButton.addActionListener(this);

        this.backButton = new JButton("Previous Menu");
        this.backButton.addActionListener(this);

        this.randomButton = new JButton("Run (random dice results)");
        this.randomButton.addActionListener(this);

        this.nonRandomButton = new JButton("Run (non-random dice results)");
        this.nonRandomButton.addActionListener(this);
        this.layoutComponents();
    }
    private void layoutComponents(){
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;

        //Pierwszy rzad
        gbc.gridy = 0;
        gbc.gridx = 1;
        add(titleLabel, gbc);
        titleLabel.setHorizontalAlignment(JLabel.CENTER);

        //nastepny rzad
        gbc.gridy++;
        gbc.gridx = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(diceQuantityLabel, gbc);
        gbc.gridx = 1;
        add(diceQuantitySpinner, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(diceRollSuccessfulResultLabel, gbc);
        gbc.gridx = 1;
        add(diceRollSuccessfulResultSpinner, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(rerollLabel, gbc);
        gbc.gridx = 1;
        add(rerollCheckBox, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(specificResultRerollLabel, gbc);
        gbc.gridx = 1;
        add(specificResultRerollSpinner, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(diceSidesLabel, gbc);
        gbc.gridx = 1;
        add(diceSidesSpinner, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(countFailuresLabel, gbc);
        gbc.gridx = 1;
        add(countFailuresCheckbox, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        add(clearButton, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx++;
        add(addDiceRollButton, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        add(backButton, gbc);
        gbc.gridx++;
        add(helpButton, gbc);

        //nastepny rzad
        gbc.gridx = 0;
        gbc.gridy++;
        add(randomButton, gbc);
        gbc.gridx++;
        add(nonRandomButton, gbc);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

//    public void setStringListener(StringListener stringListener) {
//        this.stringListener = stringListener;
//    }

    public void setClearListener(ClearListener clearListener){this.clearListener = clearListener;}

    public void setRunListener(RunListener runListener) {
        this.runListener = runListener;
    }

    public void setNonRandomRunListener(NonRandomRunListener nonRandomRunListener) {
        this.nonRandomRunListener = nonRandomRunListener;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent){
        JButton clicked = (JButton)actionEvent.getSource();
        if(clicked == clearButton){
            clearListener.clearButtonPressed();
        }
        if(clicked == helpButton){
            JFrame helpFrame = new JFrame("HELP");
        }
        if(clicked == randomButton){
            //this.stringListener.textEmitted(this.stringListener.getController().run());
            this.runListener.run();
        }
        if(clicked == nonRandomButton){
            //this.stringListener.textEmitted(this.stringListener.getController().runNonRandom());
            this.nonRandomRunListener.runNonRandom();
        }
        if(clicked == backButton){
            MainMenu mainMenu = new MainMenu();
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
            topFrame.dispose();
        }
    }
}
