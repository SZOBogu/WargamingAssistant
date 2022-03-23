package scenarioGenerator.entities;

import rosterBuilder.entities.WargamingSystem;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "deployment", schema = "wargaming_assistant")
public class Deployment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "encodedImage")
    private String encodedImage;
    @OneToOne(targetEntity = Scenario.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "scenario_id")
    private Scenario scenario;

    @ManyToOne(targetEntity = WargamingSystem.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="system_id")
    private WargamingSystem wargamingSystem;

    public Deployment() {
    }

    public Deployment(String name){
        this.name = name;
        this.encodedImage = "";
    }

    public Deployment(String name, String img){
        this.name = name;
        this.encodedImage  = img;
    }

    public Deployment(Deployment deployment){
        this(deployment.getName(), deployment.getEncodedImage());
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

    public String getEncodedImage() {
        return encodedImage;
    }

    public void setEncodedImage(String encodedImage) {
        this.encodedImage = encodedImage;
    }

    public Scenario getScenario() {
        return scenario;
    }

    public void setScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    public WargamingSystem getWargamingSystem() {
        return wargamingSystem;
    }

    public void setWargamingSystem(WargamingSystem wargamingSystem) {
        this.wargamingSystem = wargamingSystem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deployment that = (Deployment) o;
        return Objects.equals(name, that.name) && Objects.equals(encodedImage, that.encodedImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, encodedImage);
    }

    @Override
    public String toString() {
        return "Deployment{" +
                "name='" + name + '\'' +
                '}';
    }
}
