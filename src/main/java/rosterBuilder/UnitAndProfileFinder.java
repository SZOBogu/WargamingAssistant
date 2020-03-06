package rosterBuilder;

import java.util.ArrayList;

public class UnitAndProfileFinder {

    public UnitProfile getProfile(Army army, String name){
        UnitProfile unitProfile = new UnitProfile();
        for(int i = 0; i < army.size(); i++){
            if(!this.getProfile(army.getArmySubcategory(i), name).equals(new UnitProfile())){
                unitProfile = this.getProfile(army.getArmySubcategory(i), name);
                break;
            }
        }
        return unitProfile;
    }

    public UnitProfile getProfile(ArmySubcategory armySubcategory, String name){
        UnitProfile unitProfile = new UnitProfile();
        for(int i = 0; i < armySubcategory.size(); i++){
            if(armySubcategory.getUnitProfile(i).getName().equals(name)){
                unitProfile = armySubcategory.getUnitProfile(i);
                return unitProfile;
            }
        }
        return unitProfile;
    }

    public UnitProfile getProfile(Army army, Unit unit){
        return this.getProfile(army, unit.getName());
    }

    public UnitProfile getProfile(ArmySubcategory armySubcategory, Unit unit){
        return this.getProfile(armySubcategory, unit.getName());
    }

    public Unit getUnit(Roster roster, String name){
        Unit targetUnit = new Unit();

        for(int i = 0; i < roster.getDetachments().size(); i++) {
            if(!this.getUnit(roster.getDetachments().get(i), name).getName().equals("")){
                targetUnit = this.getUnit(roster.getDetachments().get(i), name);
                break;
            }
        }
        return targetUnit;
    }

    public Unit getUnit(Detachment detachment, String name){
        Unit targetUnit = new Unit();
        for(int i = 0; i < detachment.getBoughtUnitsCategorized().size(); i++) {
            if(!this.getUnit(detachment.getBoughtUnitsCategorized().get(i), name).getName().equals("")){
                targetUnit = this.getUnit(detachment.getBoughtUnitsCategorized().get(i), name);
                break;
            }
        }
        return targetUnit;
    }

    public Unit getUnit(ArrayList<Unit> units, String name){
        Unit targetUnit = new Unit();
        for (Unit unit : units) {
            if (unit.getName().equals(name)) {
                targetUnit = unit;
                return targetUnit;
            }
        }
        return targetUnit;
    }

    public Unit getUnit(Roster roster, UnitProfile unitProfile){
        return this.getUnit(roster, unitProfile.getName());
    }

    public Unit getUnit(Detachment detachment, UnitProfile unitProfile){
        return this.getUnit(detachment, unitProfile.getName());
    }

    public Unit getUnit(ArrayList<Unit> units, UnitProfile unitProfile) {
        return this.getUnit(units, unitProfile.getName());
    }
}
