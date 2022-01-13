package ScoreCalculator.helpers;

import TournamentHandler.enums.ScorePointType;
import common.ScorePoints;

public class ScoringPointOfHigherTypeGetter {
    private ScoringPointOfHigherTypeGetter(){}

    public static ScorePointType getPointOfHigherType(ScorePointType pointType){
        ScorePointType[] pointTypes = ScorePointType.values();

        for(ScorePointType type : pointTypes){
            if(type.compareTo(pointType) == 1){
                return type;
            }
        }
        return ScorePointType.EVENT_POINT;
    }
}
