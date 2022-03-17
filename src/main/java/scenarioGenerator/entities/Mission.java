package scenarioGenerator.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "mission", schema = "wargaming_assistant")
public class Mission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name="mission_objective",
            joinColumns = @JoinColumn(name="mission_id"),
            inverseJoinColumns = @JoinColumn(name = "objective_id")
    )
    private List<Objective> objectives;

    @ManyToOne(targetEntity = MissionList.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="missionList_id")
    private MissionList missionList;

    public Mission(Mission mission){
        this(mission.getName(), mission.getObjectives(), mission.getDescription());
    }

    public Mission(){
        this("Mission", new ArrayList<>(), "");
    }

    public Mission(String name, List<Objective> objectives) {
        this(name, objectives, "");
    }

    public Mission(String name, List<Objective> objectives, String description){
        this.name = name;
        this.objectives = objectives;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Objective> getObjectives() {
        return objectives;
    }

    public void setObjectives(List<Objective> objectives) {
        this.objectives = objectives;
    }

    public MissionList getMissionList() {
        return missionList;
    }

    public void setMissionList(MissionList missionList) {
        this.missionList = missionList;
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
