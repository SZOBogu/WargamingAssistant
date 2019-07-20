package rosterBuilder;

import java.util.ArrayList;

public class ArmySubcategory {
    private String name;
    private ArrayList<UnitProfile> unitProfiles;

    public ArmySubcategory(String name, ArrayList<UnitProfile> unitProfiles){
        this.name = name;
        this.unitProfiles = unitProfiles;
    }

    public String getName() {
        return name;
    }

    public UnitProfile getUnitProfile(int index) {
        return unitProfiles.get(index);
    }

    public int size(){
        return this.unitProfiles.size();
    }

}
