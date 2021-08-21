package rosterBuilder.pojos;

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
        for (Integer index : indexes) {
            entities.add(this.options.get(index).getEntity());
        }
        return entities;
    }

    public int getCost(ArrayList<Integer> indexes){
        int totalCost = 0;
        for (Integer index : indexes) {
            totalCost += this.options.get(index).getCost();
        }
        return totalCost;
    }
}
