package rosterBuilder.entities;

import javax.persistence.*;
import java.util.List;

@javax.persistence.Entity
@Table(name = "detachment_slot", schema = "wargaming_assistant")
public class DetachmentSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Basic
    @Column(name = "name")
    private String name;

    @Column(name = "unitMinimum")
    private int unitMinimum;

    @Column(name = "unitMaximum")
    private int unitMaximum;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "unit_id")
    private List<Unit> units;

    @ManyToOne(targetEntity = Detachment.class,
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="detachment_id")
    private Detachment detachment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitMinimum() {
        return unitMinimum;
    }

    public void setUnitMinimum(int unitMinimum) {
        this.unitMinimum = unitMinimum;
    }

    public int getUnitMaximum() {
        return unitMaximum;
    }

    public void setUnitMaximum(int unitMaximum) {
        this.unitMaximum = unitMaximum;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(List<Unit> units) {
        this.units = units;
    }
}
