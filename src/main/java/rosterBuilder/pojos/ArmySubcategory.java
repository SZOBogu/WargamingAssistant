package rosterBuilder.pojos;

import common.Rounder;

import java.util.ArrayList;

public class ArmySubcategory {
    private int categoryId;
    private String name;
    private ArrayList<UnitProfile> unitProfiles;
    private double categoryPointCapPercentage;
    private int categoryPointCap;

    public ArmySubcategory(){
        this.name = "";
        this.unitProfiles = new ArrayList<>();
        this.categoryPointCapPercentage = 1.0;
        this.categoryPointCap = Integer.MAX_VALUE;
    }

    public ArmySubcategory(String name, ArrayList<UnitProfile> unitProfiles){
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<UnitProfile> getUnitProfiles() {
        return unitProfiles;
    }

    public void setUnitProfiles(ArrayList<UnitProfile> unitProfiles) {
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
