package scenarioGenerator.utility;

import common.ArrayOrderMixer;
import scenarioGenerator.pojos.Mission;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMissionPackListGenerator {

    private RandomMissionPackListGenerator(){}

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
            for (List<Mission> missions : randomOrderMissionPool) {
                tempMissionList.add(missions.get(i));
            }
            randomMissionsPack.add(tempMissionList);
        }

        return randomMissionsPack;
    }

    //TODO: redo the method once you implement number of reps for each individual mission
    private static List<List<Mission>> generateWithReps(List<List<Mission>> chosenMissionPool, int scenariosToGenerate, int reps){
        for(List<Mission> missionList : chosenMissionPool){
            missionList.addAll(missionList);
        }

        return generateWithoutReps(chosenMissionPool, scenariosToGenerate);
    }

    private static List<List<Mission>> generateWithAnyReps(List<List<Mission>> chosenMissionPool, int scenariosToGenerate){
        Random random = new Random();

        List<List<Mission>> randomMissionsPack = new ArrayList<>();

        for (int i = 0; i < scenariosToGenerate; i++) {
            List<Mission> tempMissionList = new ArrayList<>();
            for (List<Mission> missions : chosenMissionPool) {
                tempMissionList.add(missions.get(random.nextInt(missions.size())));
            }
            randomMissionsPack.add(tempMissionList);
        }

        return randomMissionsPack;
    }
}