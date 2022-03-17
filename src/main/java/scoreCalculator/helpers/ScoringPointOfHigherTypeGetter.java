package scoreCalculator.helpers;

import tournamentHandler.enums.ScorePointType;

public class ScoringPointOfHigherTypeGetter {
    private ScoringPointOfHigherTypeGetter(){}

    public static ScorePointType getPointOfHigherType(ScorePointType pointType){
        if(pointType != null) {
            ScorePointType[] pointTypes = ScorePointType.values();

            for (ScorePointType type : pointTypes) {
                if (type.ordinal() - pointType.ordinal() == 1) {
                    return type;
                }
            }
            return ScorePointType.EVENT_POINT;
        }
        else return ScorePointType.SECONDARY_SCENARIO_POINT;
    }
}
