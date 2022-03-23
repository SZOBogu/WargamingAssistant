package rosterBuilder.entities;

import rosterBuilder.rules.UnitBuildingRule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "unitProfile", schema = "wargaming_assistant")
public class UnitProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "unitProfile", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private List<ModelPart> modelParts;

    @OneToMany(mappedBy = "unitProfile", cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private List<OptionSet> options;

    @Column(name = "minModels")
    private int minModels;
    @Column(name = "maxModels")
    private int maxModels;
    @Column(name = "initialCost")
    private int initialCost;
    @Column(name = "additionalModelCost")
    private int additionalModelCost;
    @Column(name = "unitsPerArmy")
    private int unitsPerArmy;
    private List<UnitBuildingRule> rules;

    public UnitProfile(){
        this("", new ArrayList<>(), new ArrayList<>(),
                0, 1, 1,0,100);
    }
    public UnitProfile(String name, List<ModelPart> modelParts, List<OptionSet> options, int initialCost){
        this(name, modelParts, options, initialCost,
                1, 1,0,100);
    }

    public UnitProfile(String name, List<ModelPart> modelParts, List<OptionSet> options,
                       int initialCost, int unitsPerArmy){
        this(name, modelParts, options, initialCost, 1, 1,0,unitsPerArmy);
    }

    public UnitProfile(String name, List<ModelPart> modelParts, List<OptionSet> options,
                       int initialCost, int minModels, int maxModels, int additionalModelCost){
        this(name, modelParts, options, initialCost, minModels, maxModels,additionalModelCost, 100);
    }

    public UnitProfile(String name, List<ModelPart> modelParts, List<OptionSet> options,
                       int initialCost, int minModels, int maxModels, int additionalModelCost, int unitsPerArmy){
        this.name = name;
        this.modelParts = modelParts;
        this.options = options;
        this.minModels = minModels;
        this.maxModels = maxModels;
        this.initialCost = initialCost;
        this.additionalModelCost = additionalModelCost;
        this.unitsPerArmy = unitsPerArmy;
        this.rules = new ArrayList<>();
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

    public List<ModelPart> getModelParts() {
        return modelParts;
    }

    public void setModelParts(List<ModelPart> modelParts) {
        this.modelParts = modelParts;
    }

    public List<OptionSet> getOptions() {
        return options;
    }

    public void setOptions(List<OptionSet> options) {
        this.options = options;
    }

    public int getMinModels() {
        return minModels;
    }

    public void setMinModels(int minModels) {
        this.minModels = minModels;
    }

    public int getMaxModels() {
        return maxModels;
    }

    public void setMaxModels(int maxModels) {
        this.maxModels = maxModels;
    }

    public int getInitialCost() {
        return initialCost;
    }

    public void setInitialCost(int initialCost) {
        this.initialCost = initialCost;
    }

    public int getAdditionalModelCost() {
        return additionalModelCost;
    }

    public void setAdditionalModelCost(int additionalModelCost) {
        this.additionalModelCost = additionalModelCost;
    }

    public int getUnitsPerArmy() {
        return unitsPerArmy;
    }

    public void setUnitsPerArmy(int unitsPerArmy) {
        this.unitsPerArmy = unitsPerArmy;
    }

    public List<UnitBuildingRule> getRules() {
        return rules;
    }

    public void setRules(List<UnitBuildingRule> rules) {
        this.rules = rules;
    }

    public List<Entity> getBaseEquipmentAndRules() {
        List<Entity> entities = new ArrayList<>();
        for (ModelPart modelsPart : this.modelParts) {
            entities.addAll(modelsPart.getEquipment());
            entities.addAll(modelsPart.getSpecialRules());
        }
        return entities;
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder(this.getName() + "\t" + this.getInitialCost() + "p\n");
        if(this.getMinModels() == this.getMaxModels() && this.getMinModels() == 1)
            string.append("Single model\n");
        else if(this.getMinModels() == this.getMaxModels())
            string.append(this.getMinModels()).append(" models\n");
        else {
            string.append(this.getMinModels()).append("-").append(this.getMaxModels()).append(" models\n");
        }
        for(int i = 0; i < this.getModelParts().size(); i++){
            string.append("\t").append(this.getModelParts().get(i).toString()).append("\n");
        }
        return string.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitProfile that = (UnitProfile) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
