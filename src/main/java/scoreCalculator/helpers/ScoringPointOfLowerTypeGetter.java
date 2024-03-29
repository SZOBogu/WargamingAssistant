package scoreCalculator.helpers;

import tournamentHandler.enums.ScorePointType;

public class ScoringPointOfLowerTypeGetter {
    private ScoringPointOfLowerTypeGetter(){}

    public static ScorePointType getPointOfLowerType(ScorePointType pointType){
        ScorePointType[] pointTypes = ScorePointType.values();

        for(ScorePointType type : pointTypes){
            if(type.compareTo(pointType) == -1){
                return type;
            }
        }
        return ScorePointType.SECONDARY_SCENARIO_POINT;
    }
}
