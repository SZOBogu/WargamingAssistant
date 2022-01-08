package scenarioGenerator.pojos;

import java.util.ArrayList;
import java.util.Objects;

public class Mission {
    private String name;
    private ArrayList<Objective> objectives;
    private String description;

    public Mission(Mission mission){
        this(mission.getName(), mission.getObjectives(), mission.getDescription());
    }

    public Mission(){
        this("Mission", new ArrayList<>(), "");
    }

    public Mission(String name, ArrayList<Objective> objectives) {
        this(name, objectives, "");
    }

    public Mission(String name, ArrayList<Objective> objectives, String description){
        this.name = name;
        this.objectives = objectives;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Objective> getObjectives() {
        return objectives;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mission mission = (Mission) o;
        return Objects.equals(name, mission.name) &&
                Objects.equals(objectives, mission.objectives) &&
                Objects.equals(description, mission.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, objectives, description);
    }

    @Override
    public String toString() {
        return "Mission{" +
                "name='" + name + '\'' +
                ", objectives=" + objectives +
                ", description='" + description + '\'' +
                '}';
    }
}
