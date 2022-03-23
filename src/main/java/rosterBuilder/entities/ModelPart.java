package rosterBuilder.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "model_part", schema = "wargaming_assistant")
public class ModelPart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "characteristic_id")
    private List<Characteristic> characteristics;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "specialRule_id")
    private List<SpecialRule> specialRules;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "equipment_id")
    private List<Entity> equipment;

    public ModelPart(){
        this("", new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
    }

    public ModelPart(String name, List<Characteristic> characteristics, List<SpecialRule> specialRules, List<Entity> equipment){
        this.name = name;
        this.characteristics = characteristics;
        this.equipment = equipment;
        this.specialRules = specialRules;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Characteristic> getCharacteristics() {
        return characteristics;
    }

    public void setCharacteristics(List<Characteristic> characteristics) {
        this.characteristics = characteristics;
    }

    public List<SpecialRule> getSpecialRules() {
        return specialRules;
    }

    public void setSpecialRules(List<SpecialRule> specialRules) {
        this.specialRules = specialRules;
    }

    public List<Entity> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Entity> equipment) {
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder(this.getName() + "\t");
        for(Characteristic characteristic: this.characteristics) {
            info.append(characteristic.getName()).append(": ").append(characteristic.getValue()).append(" ");
        }
        info.append("\t");
        for(int i = 0; i < this.specialRules.size(); i++){
            info.append(this.specialRules.get(i).toString());
            if(i != this.specialRules.size() - 1 || this.equipment.size() > 0)
                info.append(", ");
        }
        for(int i = 0; i < this.equipment.size(); i++){
            info.append(this.equipment.get(i).toString());
            if(i != this.specialRules.size() - 1)
                info.append(", ");
        }
        return info.toString();
    }
}
