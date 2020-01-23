package scenarioGenerator;

import java.util.ArrayList;

public class MissionList {
    private ArrayList<Mission> missions;
    private String name;

    public MissionList(String name){
        this(name, new ArrayList<>());
    }

    public MissionList(String name, ArrayList<Mission> missions){
        this.name = name;
        this.missions = missions;
    }

    public String getName() {
        return name;
    }

    public Mission get(int index){
        return this.missions.get(index);
    }

    public int size(){
        return this.missions.size();
    }

    public void add(Mission mission){
        this.missions.add(mission);
    }
}
