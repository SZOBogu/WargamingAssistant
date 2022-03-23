package testRosterBuilder;

import org.junit.jupiter.api.Test;
import rosterBuilder.entities.*;
import rosterBuilder.utility.UnitTakenOptionsIndexGetter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testUnitTakenOptionsIndexGetter {
    Entity eq00 = new Entity("Miecz", "+1S");
    Entity eq01 = new SpecialRule("Cieknace wiadro", "+1 do przeciekania");
    Entity eq10 = new SpecialRule("kula u nogi", "");
    Entity eq11 = new Weapon("czapka", "+Def");
    ArrayList<Entity> equipment = new ArrayList<>(Arrays.asList(eq01, eq10));

    Unit unit = new Unit.UnitBuilder("Unit", new ArrayList<>())
            .nonBaseEquipment(equipment)
            .modelsInUnit(20)
            .pointCost(1000)
            .build();

    //*************************

    Option option00 = new Option(eq00, 20);
    Option option01 = new Option(eq01, 50);
    OptionSet optionSet0 = new SingleChoiceOptionSet(new ArrayList<>(Arrays.asList(option00, option01)));

    Option option10 = new Option(eq10, 200);
    Option option11 = new Option(eq11, 500);
    OptionSet optionSet1 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(option10, option11)));

    Option option20 = new Option(new Weapon("Tarcza", "+Def"), 200);
    Option option21 = new Option(new Entity("lekka zbroja", "+1S"), 500);
    OptionSet optionSet2 = new MultipleChoiceOptionSet(new ArrayList<>(Arrays.asList(option20, option21)));

    ModelPart modelPart0 = new ModelPart("Model", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    ArrayList<ModelPart> modelParts = new ArrayList<>();
    ArrayList<OptionSet> optionSets = new ArrayList<>(Arrays.asList(optionSet0, optionSet1, optionSet2));

    UnitProfile unitProfile = new UnitProfile("Unit", modelParts, optionSets, 100);

    @Test
    void testGetTakenOptionsIndexes(){
        modelParts.add(modelPart0);

        List<List<Integer>> results = UnitTakenOptionsIndexGetter.getTakenOptionsIndexes(unit, unitProfile);
        assertEquals(2, results.size());
        assertEquals(new ArrayList<>(Arrays.asList(0,1)),results.get(0));
        assertEquals(new ArrayList<>(Arrays.asList(1,0)),results.get(1));
    }
}
