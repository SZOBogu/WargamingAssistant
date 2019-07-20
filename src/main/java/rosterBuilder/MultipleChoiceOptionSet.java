package rosterBuilder;

import java.util.ArrayList;

public class MultipleChoiceOptionSet extends OptionSet{
    public MultipleChoiceOptionSet(ArrayList<Option> options){
        super(options);
    }
    public MultipleChoiceOptionSet(ArrayList<Option> options, boolean isMandatory){
        super(options, isMandatory);
    }
    public MultipleChoiceOptionSet(ArrayList<Option> options, String itemListName, String keyVerb){
        super(options, itemListName, keyVerb);
    }
    public MultipleChoiceOptionSet(ArrayList<Option> options, String itemListName, String keyVerb, boolean isMandatory){
        super(options, itemListName, keyVerb, isMandatory);
    }

    public ArrayList<Entity> getEntities(ArrayList<Integer> indexes){
        ArrayList<Entity> entities = new ArrayList<>();
        for(int i =0; i < indexes.size(); i++){
            entities.add(this.options.get(indexes.get(i)).getEntity());
        }
        return entities;
    }

    public int getCost(ArrayList<Integer> indexes){
        int totalCost = 0;
        for(int i =0; i < indexes.size(); i++){
            totalCost += this.options.get(indexes.get(i)).getCost();
        }
        return totalCost;
    }
}
