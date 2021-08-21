package rosterBuilder.utility;

import rosterBuilder.pojos.*;

import java.util.List;

public class UnitAndProfileFinder {

    private UnitAndProfileFinder(){}

    public static UnitProfile getProfile(Army army, String name){
        UnitProfile unitProfile = new UnitProfile();
        for(int i = 0; i < army.size(); i++){
            if(!UnitAndProfileFinder.getProfile(army.getArmySubcategory(i), name).equals(new UnitProfile())){
                unitProfile = UnitAndProfileFinder.getProfile(army.getArmySubcategory(i), name);
                break;
            }
        }
        return unitProfile;
    }

    public static UnitProfile getProfile(ArmySubcategory armySubcategory, String name){
        UnitProfile unitProfile = new UnitProfile();
        for(int i = 0; i < armySubcategory.size(); i++){
            if(armySubcategory.getUnitProfile(i).getName().equals(name)){
                unitProfile = armySubcategory.getUnitProfile(i);
                return unitProfile;
            }
        }
        return unitProfile;
    }

    public static UnitProfile getProfile(Army army, Unit unit){
        return UnitAndProfileFinder.getProfile(army, unit.getName());
    }

    public static UnitProfile getProfile(ArmySubcategory armySubcategory, Unit unit){
        return UnitAndProfileFinder.getProfile(armySubcategory, unit.getName());
    }

    public static Unit getUnit(Roster roster, String name){
        Unit targetUnit = new Unit();

        for(int i = 0; i < roster.getDetachments().size(); i++) {
            if(!UnitAndProfileFinder.getUnit(roster.getDetachments().get(i), name).getName().equals("")){
                targetUnit = UnitAndProfileFinder.getUnit(roster.getDetachments().get(i), name);
                break;
            }
        }
        return targetUnit;
    }

    public static Unit getUnit(Detachment detachment, String name){
        Unit targetUnit = new Unit();
        for(int i = 0; i < detachment.getBoughtUnitsCategorized().size(); i++) {
            if(!UnitAndProfileFinder.getUnit(detachment.getBoughtUnitsCategorized().get(i), name).getName().equals("")){
                targetUnit = UnitAndProfileFinder.getUnit(detachment.getBoughtUnitsCategorized().get(i), name);
                break;
            }
        }
        return targetUnit;
    }

    public static Unit getUnit(List<Unit> units, String name){
        Unit targetUnit = new Unit();
        for (Unit unit : units) {
            if (unit.getName().equals(name)) {
                targetUnit = unit;
                return targetUnit;
            }
        }
        return targetUnit;
    }

    public static Unit getUnit(Roster roster, UnitProfile unitProfile){
        return UnitAndProfileFinder.getUnit(roster, unitProfile.getName());
    }

    public static Unit getUnit(Detachment detachment, UnitProfile unitProfile){
        return UnitAndProfileFinder.getUnit(detachment, unitProfile.getName());
    }

    public static Unit getUnit(List<Unit> units, UnitProfile unitProfile) {
        return UnitAndProfileFinder.getUnit(units, unitProfile.getName());
    }
}
