package scenarioGenerator.entities;

import rosterBuilder.pojos.WargamingSystem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "scenario", schema = "wargaming_assistant")
public class Scenario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToOne(targetEntity = Deployment.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="deployment_id")
    private Deployment deployment;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "scenario_id")
    private List<Mission> missions;

    @ManyToOne(targetEntity = WargamingSystem.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="system_id")
    private WargamingSystem wargamingSystem;

    public Scenario(){
        this("Scenario", new Deployment("Deployment"), new ArrayList<Mission>());
    }

    public Scenario(String name, Deployment deployment, List<Mission> missions){
        this.name = name;
        this.deployment = deployment;
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

    public Deployment getDeployment() {
        return deployment;
    }

    public void setDeployment(Deployment deployment) {
        this.deployment = deployment;
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
}
