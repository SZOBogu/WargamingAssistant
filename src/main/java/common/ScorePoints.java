package common;

import scenarioGenerator.entities.Objective;
import tournamentHandler.enums.ScorePointType;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "score_points", schema = "wargaming_assistant")
public class ScorePoints {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "points")
    private int points;

    @Enumerated(EnumType.STRING)
    private ScorePointType type;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "objective_id")
    private List<Objective> objectiveList;

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public ScorePointType getType() {
        return type;
    }

    public void setType(ScorePointType type) {
        this.type = type;
    }
}
