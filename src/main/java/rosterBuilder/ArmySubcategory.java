package rosterBuilder;

import common.Rounder;

import java.util.ArrayList;

public class ArmySubcategory {
    private String name;
    private ArrayList<UnitProfile> unitProfiles;
    private double categoryPointCapPercentage;
    private int categoryPointCap;

    public ArmySubcategory(String name){
        this.name = name;
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

    public String getName() {
        return name;
    }

    public UnitProfile getUnitProfile(int index) {
        return unitProfiles.get(index);
    }

    public int size(){
        return this.unitProfiles.size();
    }

    public void setCategoryPointCapPercentage(double categoryPointCapPercentage){
        this.categoryPointCapPercentage = categoryPointCapPercentage;
    }

    public double getCategoryPointCapPercentage() {
        return categoryPointCapPercentage;
    }

    public void setCategoryPointCap(int categoryPointCap){
        this.categoryPointCap = categoryPointCap;
    }

    public int getCategoryPointCap() {
        return categoryPointCap;
    }

    public void setCategoryPointCap(Roster roster){
        this.categoryPointCap = roster.getPointCap();
    }

    public void setUnitProfiles(ArrayList<UnitProfile> unitProfiles) {
        this.unitProfiles = unitProfiles;
    }

    public void recalculateCategoryPointCap() {
        this.categoryPointCap = (int)Rounder.round(this.categoryPointCapPercentage * this.categoryPointCap);
    }
}
