package scoreCalculator.pojos;

public class ScoreList {
    private ScoreList secondaryScenarioPoints;
    private ScoreList primaryScenarioPoints;
    private ScoreList gamePoints;
    private ScoreList matchPoints;
    private ScoreList eventPoints;

    public ScoreList getSecondaryScenarioPoints() {
        return secondaryScenarioPoints;
    }

    public void setSecondaryScenarioPoints(ScoreList secondaryScenarioPoints) {
        this.secondaryScenarioPoints = secondaryScenarioPoints;
    }

    public ScoreList getPrimaryScenarioPoints() {
        return primaryScenarioPoints;
    }

    public void setPrimaryScenarioPoints(ScoreList primaryScenarioPoints) {
        this.primaryScenarioPoints = primaryScenarioPoints;
    }

    public ScoreList getGamePoints() {
        return gamePoints;
    }

    public void setGamePoints(ScoreList gamePoints) {
        this.gamePoints = gamePoints;
    }

    public ScoreList getMatchPoints() {
        return matchPoints;
    }

    public void setMatchPoints(ScoreList matchPoints) {
        this.matchPoints = matchPoints;
    }

    public ScoreList getEventPoints() {
        return eventPoints;
    }

    public void setEventPoints(ScoreList eventPoints) {
        this.eventPoints = eventPoints;
    }
}
