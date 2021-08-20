package scenarioGenerator.helpers;

import common.ArrayOrderMixer;
import scenarioGenerator.Mission;
import scenarioGenerator.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMissionGenerator {
    public static  List<List<Mission>> generate(ScenarioRequest request, List<List<Mission>> chosenMissionPool){
        if(request.isCanDuplicateMissions() && request.isDuplicateMissionsFreely()){
            return generateWithAnyReps(chosenMissionPool, request.getScenariosToGenerate());
        }
        else if(request.isCanDuplicateMissions() && !request.isDuplicateMissionsFreely() && request.getDuplicateMissionsQuantity() > 1){
            return generateWithReps(chosenMissionPool, request.getScenariosToGenerate(), request.getDuplicateMissionsQuantity());
        }
        else{
            return generateWithoutReps(chosenMissionPool, request.getScenariosToGenerate());
        }
    }

    private static List<List<Mission>> generateWithoutReps(List<List<Mission>> chosenMissionPool, int scenariosToGenerate){
        List<List<Mission>> randomMissionsPack = new ArrayList<>();
        List<List<Mission>> randomOrderMissionPool = new ArrayList<>();

        for(List<Mission> missionList : chosenMissionPool){
            randomOrderMissionPool.add(ArrayOrderMixer.getArrayInRandomOrder(missionList));
        }

        System.out.println("randomOrderMissionPool: \n" + randomOrderMissionPool);

        for (int i = 0; i < scenariosToGenerate; i++) {
            List<Mission> tempMissionList = new ArrayList<>();
            for (int j = 0; j < randomOrderMissionPool.size(); j++) {
                tempMissionList.add(randomOrderMissionPool.get(j).get(i));
            }
            randomMissionsPack.add(tempMissionList);
        }

        return randomMissionsPack;
    }

    //TODO: redo the method once you implement number of reps for each individual mission
    private static List<List<Mission>> generateWithReps(List<List<Mission>> chosenMissionPool, int scenariosToGenerate, int reps){
        System.out.println(reps + " DUPES");

        List<List<Mission>> randomMissionsPack = new ArrayList<>();

        for(List<Mission> missionList : chosenMissionPool){
            missionList.addAll(missionList);
        }

        return generateWithoutReps(chosenMissionPool, scenariosToGenerate);
    }

    private static List<List<Mission>> generateWithAnyReps(List<List<Mission>> chosenMissionPool, int scenariosToGenerate){
        System.out.println("ANY DUPES");

        Random random = new Random();

        List<List<Mission>> randomMissionsPack = new ArrayList<>();

        for (int i = 0; i < scenariosToGenerate; i++) {
            List<Mission> tempMissionList = new ArrayList<>();
            for (int j = 0; j < chosenMissionPool.size(); j++) {
                tempMissionList.add(chosenMissionPool.get(j).get(random.nextInt(chosenMissionPool.get(j).size())));
            }
            randomMissionsPack.add(tempMissionList);
        }

        return randomMissionsPack;
    }
}