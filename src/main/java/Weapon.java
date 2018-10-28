import java.util.ArrayList;

public class Weapon extends Item{

    private ArrayList<Statistic> statLine;

    public Weapon(String name, String description, ArrayList statLine){
        super(name, description);
        this.statLine = statLine;
    }

    public ArrayList<Statistic> getStatLine() {
        return statLine;
    }
}
