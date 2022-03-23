package rosterBuilder.helpers;

import rosterBuilder.pojos.IWargameInitializer;
import rosterBuilder.entities.WargamingSystem;

import java.util.ArrayList;

public class WargameSystemsInitializer {
    private ArrayList<IWargameInitializer> initializers;

    public WargameSystemsInitializer(){
        this.initializers = new ArrayList<>();
        this.initializers.add(new T9A_Initializer());
    }

    public ArrayList<WargamingSystem> initialize(){
        ArrayList<WargamingSystem> wargamingSystems = new ArrayList<>();
        for (IWargameInitializer initializer : this.initializers) {
            wargamingSystems.add(initializer.initWargame());
        }
        return wargamingSystems;
    }
}
