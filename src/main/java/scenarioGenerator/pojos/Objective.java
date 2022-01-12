package scenarioGenerator.pojos;

import common.ScorePoints;

public class Objective {
    private String name;
    private ScorePoints victoryPoints;

    public Objective(){
        this.name = "Objective 0";
        this.victoryPoints = new ScorePoints();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ScorePoints getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(ScorePoints victoryPoints) {
        this.victoryPoints = victoryPoints;
    }
}
