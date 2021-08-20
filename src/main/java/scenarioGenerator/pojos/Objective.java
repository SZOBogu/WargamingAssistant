package scenarioGenerator.pojos;

public class Objective {
    private String name;
    private int victoryPoints;

    public Objective(){
        this("Objective", 1);
    }

    public Objective(String name){
        this(name, 1);
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
