package scenarioGenerator.entities;

import common.ScorePoints;
import rosterBuilder.pojos.WargamingSystem;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "objective", schema = "wargaming_assistant")
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @ManyToOne(targetEntity = ScorePoints.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="points_id")
    private ScorePoints victoryPoints;

    @ManyToMany(
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH}
    )
    @JoinTable(
            name="mission_objective",
            joinColumns = @JoinColumn(name="mission_id"),
            inverseJoinColumns = @JoinColumn(name = "objective_id")
    )
    private List<Mission> missionList;

    public Objective(){
        this.name = "Objective 0";
        this.victoryPoints = new ScorePoints();
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

    public ScorePoints getVictoryPoints() {
        return victoryPoints;
    }

    public void setVictoryPoints(ScorePoints victoryPoints) {
        this.victoryPoints = victoryPoints;
    }

    public List<Mission> getMissionList() {
        return missionList;
    }

    public void setMissionList(List<Mission> missionList) {
        this.missionList = missionList;
    }
}
