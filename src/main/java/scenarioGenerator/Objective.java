package scenarioGenerator;

public class Objective {
    private String name;
    private int victoryPoints;

    public Objective(){
        this.name = "Objective";
        this.victoryPoints = 1;
    }

    public Objective(String name){
        this.name = name;
        this.victoryPoints = 1;
    }

    public Objective(String name, int vp){
        this.name = name;
        this.victoryPoints = vp;
    }

    public String getName() {
        return name;
    }

    public int getVictoryPoints() {
        return victoryPoints;
    }
}
