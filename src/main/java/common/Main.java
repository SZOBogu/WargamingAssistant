package common;

import diceRollSimulator.DiceRollMenu;
import rosterBuilder.RuleViolationLog;
import rosterBuilder.WargamingSystem;
import scenarioGenerator.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                MainMenu frame = new MainMenu();
            }
        });
    }
}