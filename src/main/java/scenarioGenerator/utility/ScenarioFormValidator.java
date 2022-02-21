package scenarioGenerator.utility;

import scenarioGenerator.pojos.Mission;
import scenarioGenerator.requests.ScenarioRequest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ScenarioFormValidator {

    private ScenarioFormValidator(){}


    public static boolean canBeGenerated(ScenarioRequest request){
        if(request.isOneMissionPool()){
            return canBeGeneratedWithOnePool(request);
        }
        else{
            return canBeGeneratedWithManyPools(request);
        }
    }
    //for handling one mission per pack requirement
    private static boolean canBeGeneratedWithManyPools(ScenarioRequest request){
        int deploymentQuantity = request.getDeploymentPool().stream().reduce(0, Integer::sum);
        int missionQuantity = request.getMissionPool().stream().flatMap(Collection::stream).reduce(0, Integer::sum);

        for(List<Integer> missions : request.getMissionPool()){
            if(missions.stream().reduce(0, Integer::sum) < request.getScenariosToGenerate())
                return false;
        }

        return canBeGeneratedWithOnePool(request);
    }

    //for handling one pool of missions
    private static boolean canBeGeneratedWithOnePool(ScenarioRequest request){
        int deploymentQuantity = request.getDeploymentPool().stream().reduce(0, Integer::sum);
        int missionQuantity = request.getMissionPool().stream().flatMap(Collection::stream).reduce(0, Integer::sum);

        if (deploymentQuantity >= request.getScenariosToGenerate() && missionQuantity >= request.getScenariosToGenerate())
            return true;
        else
            return false;
    }
}
