package rosterBuilder.entities;

import common.Rounder;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "army_subcategory", schema = "wargaming_assistant")
public class ArmySubcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "unitProfile_id")
    private List<UnitProfile> unitProfiles;
    @Basic
    @Column(name = "categoryPointCapPercentage")
    private double categoryPointCapPercentage;
    @Basic
    @Column(name = "categoryPointCap")
    private int categoryPointCap;

    public ArmySubcategory(){
        this.name = "";
        this.unitProfiles = new ArrayList<>();
        this.categoryPointCapPercentage = 1.0;
        this.categoryPointCap = Integer.MAX_VALUE;
    }

    public ArmySubcategory(String name, List<UnitProfile> unitProfiles){
        this.name = name;
        this.unitProfiles = unitProfiles;
        this.categoryPointCapPercentage = 1.0;
        this.categoryPointCap = Integer.MAX_VALUE;
    }
    public UnitProfile getUnitProfile(int index) {
        return unitProfiles.get(index);
    }

    public int size(){
        return this.unitProfiles.size();
    }

    public void recalculateCategoryPointCap() {
        this.categoryPointCap = (int)Rounder.round(this.categoryPointCapPercentage * this.categoryPointCap);
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

    public List<UnitProfile> getUnitProfiles() {
        return unitProfiles;
    }

    public void setUnitProfiles(List<UnitProfile> unitProfiles) {
        this.unitProfiles = unitProfiles;
    }

    public double getCategoryPointCapPercentage() {
        return categoryPointCapPercentage;
    }

    public void setCategoryPointCapPercentage(double categoryPointCapPercentage) {
        this.categoryPointCapPercentage = categoryPointCapPercentage;
    }

    public int getCategoryPointCap() {
        return categoryPointCap;
    }

    public void setCategoryPointCap(int categoryPointCap) {
        this.categoryPointCap = categoryPointCap;
    }
}
