package scenarioGenerator.entities;

import rosterBuilder.entities.WargamingSystem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "missionList", schema = "wargaming_assistant")
public class MissionList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "missionList_id")
    private List<Mission> missions;
    @ManyToOne(targetEntity = WargamingSystem.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="system_id")
    private WargamingSystem wargamingSystem;

    public MissionList() {
    }

    public MissionList(String name){
        this(name, new ArrayList<>());
    }

    public MissionList(String name, List<Mission> missions){
        this.name = name;
        this.missions = missions;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Mission> getMissions() {
        return missions;
    }

    public void setMissions(List<Mission> missions) {
        this.missions = missions;
    }

    public WargamingSystem getWargamingSystem() {
        return wargamingSystem;
    }

    public void setWargamingSystem(WargamingSystem wargamingSystem) {
        this.wargamingSystem = wargamingSystem;
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
