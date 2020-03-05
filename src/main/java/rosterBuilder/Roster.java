package rosterBuilder;

import java.util.ArrayList;

public class Roster {
    private ArrayList<Detachment> detachments;
    private Army primaryArmy;
    private int pointCap;

    public Roster(){
        this.detachments = new ArrayList<>();
        this.primaryArmy = null;
        this.pointCap = 0;
    }

    public void addDetachment(Detachment detachment){
        this.detachments.add(detachment);
    }

    public void removeDetachment(int index){
       Detachment detachment = this.detachments.get(index);
       for(int i = 0; i < detachment.getBoughtUnitsCategorized().size(); i++){      //po detkach
           for (int j = 0; j < detachment.getBoughtUnitsCategorized().get(i).size(); j++) {  //po kategoriach
               detachment.deleteUnit(i, j);
           }
       }
       this.detachments.remove(index);
    }

    public int size(){
        return this.detachments.size();
    }

    public ArrayList<Detachment> getDetachments() {
        return detachments;
    }

    public int getPointCap() {
        return pointCap;
    }

    public void setPointCap(int pointCap) {
        this.pointCap = pointCap;
    }

    public int getTotalCost() {
       int totalCost = 0;
        for (Detachment detachment : this.detachments) {
            totalCost += detachment.getCost();
        }
       return totalCost;
    }

    public Army getPrimaryArmy() {
        return primaryArmy;
    }

    public void setPrimaryArmy(Army primaryArmy) {
        this.primaryArmy = primaryArmy;
    }

    public Army getArmy(int index){
        return this.detachments.get(index).getArmy();
    }

    @Override
    public String toString(){
        StringBuilder string = new StringBuilder();
        if(this.primaryArmy != null)
            string = new StringBuilder(this.primaryArmy.getName() + " " + getPointCap() + "p Army\n");
        else
            string = new StringBuilder(getPointCap() + "p Army");
        for(int i = 0; i < this.getDetachments().size(); i++){
            string.append(this.getDetachments().get(i).toString());
        }
        return string.toString();
    }
}
