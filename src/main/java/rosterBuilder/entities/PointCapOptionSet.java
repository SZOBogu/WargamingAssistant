package rosterBuilder.entities;

import rosterBuilder.exceptions.UnitBuildingException;

import java.util.ArrayList;

public class PointCapOptionSet extends MultipleChoiceOptionSet{
    private int pointCap;

    public PointCapOptionSet(){
        super();
    }

    public PointCapOptionSet(ArrayList<Option> options, int pointCap){
        super(options);
        this.pointCap = pointCap;
    }
    public PointCapOptionSet(ArrayList<Option> options, boolean isMandatory, int pointCap){
        super(options, isMandatory);
        this.pointCap = pointCap;
    }
    public PointCapOptionSet(ArrayList<Option> options, String itemListName, String keyVerb, int pointCap){
        super(options, itemListName, keyVerb);
        this.pointCap = pointCap;
    }
    public PointCapOptionSet(ArrayList<Option> options, String itemListName, String keyVerb,
                             boolean isMandatory, int pointCap){
        super(options, itemListName, keyVerb, isMandatory);
        this.pointCap = pointCap;
    }

    public int getPointCap() {
        return pointCap;
    }

    public void setPointCap(int pointCap) {
        this.pointCap = pointCap;
    }

    @Override
    public ArrayList<Entity> getEntities(ArrayList<Integer> indexes){
        if(getCost(indexes) > this.pointCap){
            throw new UnitBuildingException("Point cap on option set exceeded");
        }
        return super.getEntities(indexes);
    }

    @Override
    public String getDescription(){
        String string = super.getDescription();
        return string.substring(0, string.length() - 1) + " (max " + this.pointCap +" points):";
    }
}
