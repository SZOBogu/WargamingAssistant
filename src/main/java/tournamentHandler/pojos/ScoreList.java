package tournamentHandler.pojos;

import tournamentHandler.enums.ScorePointType;
import common.ScorePoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ScoreList implements Comparable{
    private List<ScorePoints> scorePointsList;

    public ScoreList() {
        this.scorePointsList = new ArrayList<>();
        ScorePoints eventScore = new ScorePoints();
        ScorePoints matchScore = new ScorePoints();
        ScorePoints gameScore = new ScorePoints();
        ScorePoints primaryScenScore = new ScorePoints();
        ScorePoints secondaryScenScore = new ScorePoints();

        eventScore.setType(ScorePointType.EVENT_POINT);
        matchScore.setType(ScorePointType.MATCH_POINT);
        gameScore.setType(ScorePointType.GAME_POINT);
        primaryScenScore.setType(ScorePointType.PRIMARY_SCENARIO_POINT);
        secondaryScenScore.setType(ScorePointType.SECONDARY_SCENARIO_POINT);

        this.scorePointsList.addAll(Arrays.asList(eventScore, matchScore, gameScore, primaryScenScore, secondaryScenScore));
    }

    public List<ScorePoints> getScorePointsList() {
        return scorePointsList;
    }

    public void setScorePointsList(List<ScorePoints> scorePointsList) {
        this.scorePointsList = scorePointsList;
    }

    public void addPoints(ScorePoints points){
        for(ScorePoints p : this.scorePointsList){
            if(p.getType() == points.getType()){
                p.setPoints(p.getPoints() + points.getPoints());
            }
        }
    }

    @Override
    public int compareTo(Object o) {
        ScoreList scoreList = (ScoreList) o;
        List<ScorePointType> types = new ArrayList<ScorePointType>(Arrays.asList(ScorePointType.values()));
        Collections.reverse(types);
        for(ScorePointType type : types){
            for(ScorePoints points1 : this.scorePointsList){
                for(ScorePoints points2 : scoreList.getScorePointsList()){
                    if(points1.getType() == type && points2.getType() == type){
                        int comparison = Integer.compare(points1.getPoints(), points2.getPoints());
                        if(comparison != 0)
                            return comparison;
                    }
                }
            }
        }
        return 0;
    }
}
