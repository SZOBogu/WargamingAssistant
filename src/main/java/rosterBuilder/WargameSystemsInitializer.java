package rosterBuilder;

import java.util.ArrayList;

public class WargameSystemsInitializer {
    private ArrayList<IWargameInitializer> initializers;

    public WargameSystemsInitializer(){
        this.initializers = new ArrayList<>();
        this.initializers.add(new T9A_Initializer());
    }

    public ArrayList<WargamingSystem> initialize(){
        ArrayList<WargamingSystem> wargamingSystems = new ArrayList<>();
        for(int i = 0; i < this.initializers.size(); i++){
            wargamingSystems.add(this.initializers.get(i).initWargame());
        }
        return wargamingSystems;
    }
}
