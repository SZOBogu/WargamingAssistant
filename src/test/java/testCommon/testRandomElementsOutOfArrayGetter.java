package testCommon;

import common.RandomElementsOutOfArrayGetter;
import org.junit.jupiter.api.Test;
import rosterBuilder.*;
import scenarioGenerator.Deployment;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class testRandomElementsOutOfArrayGetter {
    RandomElementsOutOfArrayGetter getter = new RandomElementsOutOfArrayGetter();
    List<Object> dummyList = Arrays.asList(1,2,3);

    Deployment deployment0 = new Deployment("Deployment 0", new ImageIcon("/home/bogu/IdeaProjects/GUI//src/main/img/T9A/deployments/0.png"));
    Deployment deployment1 = new Deployment("Deployment 1", new ImageIcon("/home/bogu/IdeaProjects/GUI//src/main/img/T9A/deployments/1.png"));
    Deployment deployment2 = new Deployment("Deployment 2", new ImageIcon("/home/bogu/IdeaProjects/GUI//src/main/img/T9A/deployments/2.png"));
    List<Object> deploymentList = Arrays.asList(deployment0, deployment1, deployment2);
    @Test
    void testRandomArrayWithoutReps() {
        List<Object> resultList = getter.randomArrayWithoutReps(dummyList, 2);
        assertEquals(resultList.size(), 2);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
        assertNotSame(resultList.get(1), resultList.get(0));
    }

    @Test
    void testRandomArrayWithRepsArray() {
        List<Integer> repList = Arrays.asList(5,2,0);
        List<Object> resultList = getter.randomArrayWithReps(dummyList, repList, 3);
        assertEquals(resultList.size(), 3);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
        assertTrue((Integer)resultList.get(2) > 0 && (Integer)resultList.get(2) < 4);
        assertNotSame(resultList.get(0), dummyList.get(2));
        assertNotSame(resultList.get(1), dummyList.get(2));
        assertNotSame(resultList.get(2), dummyList.get(2));
        int reps = 0;
        for(int i = 0 ; i < resultList.size(); i++){
            if((Integer)resultList.get(i) == 2) {
                reps++;
            }
        }
        if(reps > 2){
            fail();
        }
    }

    @Test
    void testRandomArrayWithRepsInt() {
        List<Object> resultList = getter.randomArrayWithReps(dummyList, 2, 3);
        assertEquals(resultList.size(), 3);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
        assertTrue((Integer)resultList.get(2) > 0 && (Integer)resultList.get(2) < 4);

        for(int i = 0 ; i < dummyList.size(); i++){
            int reps = 0;
            for(int j = 0; j < resultList.size(); j++){
                if(resultList.get(j) == dummyList.get(i))
                    reps++;
            }
            if(reps > 2)
                fail();
        }
    }

    @Test
    void testRandomArrayWithAnyReps() {
        List<Object> resultList = getter.randomArrayWithAnyReps(dummyList, 2);
        assertEquals(resultList.size(), 2);
        assertTrue((Integer)resultList.get(0) > 0 && (Integer)resultList.get(0) < 4);
        assertTrue((Integer)resultList.get(1) > 0 && (Integer)resultList.get(1) < 4);
    }

    @Test
    void testOnUnitProfiles(){
        Option option000 = new Option(new Weapon("Pala", "bum bum"), 20);
        Option option001 = new Option(new SpecialRule("skirmish", "asdas"), 50);
        OptionSet optionSet00 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option000, option001)));

        Option option010 = new Option(new Weapon("Miecz", "bam bam"), 200);
        Option option011 = new Option(new SpecialRule("block", "asdasa"), 500);
        OptionSet optionSet01 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option010, option011)));

        Weapon eq000 = new Weapon("Palasz", "bum bum");
        Entity eq001 =    new Entity("kutrka", "asd");
        SpecialRule sr000 = new SpecialRule("fast", "asdas");
        SpecialRule sr001 = new SpecialRule("fearless", "like, really");
        ArrayList<Entity> equipment00 = new ArrayList<>(Arrays.asList(eq000, eq001));
        ArrayList<SpecialRule> specialRules00 = new ArrayList<>(Arrays.asList(sr000, sr001));
        Statistic statistic000 = new Statistic("S", "1");
        Statistic statistic001 = new Statistic("D", "-1");
        Statistic statistic002 = new Statistic("toHit", "3+");
        Statline statline00 = new Statline(new ArrayList<>(Arrays.asList(statistic000, statistic001, statistic002)));

        ModelPart modelPart00 = new ModelPart("Model00", statline00, specialRules00, equipment00);

        Weapon eq010 = new Weapon("Pala", "bum bum");
        Entity eq011 =    new Entity("plaszcz", "asd");
        SpecialRule sr010 = new SpecialRule("skrmish", "asdas");
        SpecialRule sr011 = new SpecialRule("swift", "like, really");
        ArrayList<Entity> equipment01 = new ArrayList<>(Arrays.asList(eq010, eq011));
        ArrayList<SpecialRule> specialRules01 = new ArrayList<>(Arrays.asList(sr010, sr011));
        Statistic statistic010 = new Statistic("S", "1");
        Statistic statistic011 = new Statistic("D", "-1");
        Statistic statistic012 = new Statistic("toHit", "3+");
        Statline statline01 = new Statline(new ArrayList<>(Arrays.asList(statistic010, statistic011, statistic012)));

        ModelPart modelPart01 = new ModelPart("Model00", statline01, specialRules01, equipment01);

        ArrayList<ModelPart> modelParts0 = new ArrayList<>(Arrays.asList(modelPart00, modelPart01));
        ArrayList<OptionSet> optionSets0 = new ArrayList<>(Arrays.asList(optionSet00, optionSet01));

        UnitProfile unitProfile0 = new UnitProfile("Profile 0", modelParts0, optionSets0, 100);

        Option option100 = new Option(new Weapon("pistolet", "paf paf"), 20);
        Option option101 = new Option(new SpecialRule("atsknf", "sm"), 50);
        OptionSet optionSet10 = new SingleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option100, option101)));

        Option option110 = new Option(new Weapon("szabla", "ciah ciach"), 200);
        Option option111 = new Option(new SpecialRule("hatred", "re roll 1"), 500);
        OptionSet optionSet11 = new MultipleChoiceOptionSet(new ArrayList<Option>(Arrays.asList(option110, option111)));

        Weapon eq100 = new Weapon("laser", "bziu");
        Entity eq101 =    new Entity("zbroja", "assd");
        SpecialRule sr100 = new SpecialRule("s&p", "s&ps");
        SpecialRule sr101 = new SpecialRule("relentless", "ssssaa");
        ArrayList<Entity> equipment10 = new ArrayList<>(Arrays.asList(eq100, eq101));
        ArrayList<SpecialRule> specialRules10 = new ArrayList<>(Arrays.asList(sr100, sr101));
        Statistic statistic100 = new Statistic("Aim", "d20");
        Statistic statistic101 = new Statistic("Wounds", "10");
        Statistic statistic102 = new Statistic("Save", "3+");
        Statline statline10 = new Statline(new ArrayList<>(Arrays.asList(statistic100, statistic101, statistic102)));

        ModelPart modelPart10 = new ModelPart("Model10", statline10, specialRules10, equipment10);

        Weapon eq110 = new Weapon("Pala", "bum bum");
        Entity eq111 =    new Entity("plaszcz", "asd");
        SpecialRule sr110 = new SpecialRule("skrmish", "asdas");
        SpecialRule sr111 = new SpecialRule("swift", "like, really");
        ArrayList<Entity> equipment11 = new ArrayList<>(Arrays.asList(eq110, eq111));
        ArrayList<SpecialRule> specialRules11 = new ArrayList<>(Arrays.asList(sr110, sr111));
        Statistic statistic110 = new Statistic("S", "1");
        Statistic statistic111 = new Statistic("D", "-1");
        Statistic statistic112 = new Statistic("toHit", "3+");
        Statline statline11 = new Statline(new ArrayList<>(Arrays.asList(statistic110, statistic111, statistic112)));

        ModelPart modelPart11 = new ModelPart("Model11", statline11, specialRules11, equipment11);

        ArrayList<ModelPart> modelParts1 = new ArrayList<>(Arrays.asList(modelPart10, modelPart11));
        ArrayList<OptionSet> optionSets1 = new ArrayList<>(Arrays.asList(optionSet10, optionSet11));

        UnitProfile unitProfile1 = new UnitProfile("Profile 1", modelParts1, optionSets1, 200);
        UnitProfile unitProfile2 = new UnitProfile("Profile 2", modelParts0, optionSets1, 5000);

        List<Object> profileList = Arrays.asList(unitProfile0, unitProfile1, unitProfile2);

        List<Object> profileResultList = getter.randomArrayWithoutReps(profileList, 2);
        assertTrue(profileResultList.get(0).toString().equals(unitProfile0.toString()) ||
                profileResultList.get(0).toString().equals(unitProfile1.toString()) ||
                profileResultList.get(0).toString().equals(unitProfile2.toString()));
        assertTrue(profileResultList.get(1).toString().equals(unitProfile0.toString()) ||
                profileResultList.get(1).toString().equals(unitProfile1.toString()) ||
                profileResultList.get(1).toString().equals(unitProfile2.toString()));

        System.out.println(profileResultList.get(0));
        System.out.println(profileResultList.get(1));
    }
}
