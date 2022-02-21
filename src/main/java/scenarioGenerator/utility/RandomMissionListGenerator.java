package scenarioGenerator.utility;

import common.ArrayOrderMixer;
import scenarioGenerator.pojos.Mission;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomMissionListGenerator {

    private RandomMissionListGenerator(){}

    public static  List<List<Mission>> generate(ScenarioRequest request, List<List<Mission>> chosenMissionPool){
        List<List<Mission>> missionPool = new ArrayList<>();
        missionPool.add(new ArrayList<>());

        if(request.isOneMissionPool()){
            for(List<Mission> missions : chosenMissionPool){
                missionPool.get(0).addAll(missions);
            }
        }
        if(request.isDuplicateMissionsFreely()){
            return generateWithoutReps(missionPool, request.getScenariosToGenerate());
        }
        else{
            return generateWithAnyReps(missionPool, request.getScenariosToGenerate());
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