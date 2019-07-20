package rosterBuilder;

import java.util.ArrayList;

public class SingleChoiceOptionSet extends OptionSet {
    public SingleChoiceOptionSet(ArrayList<Option> options){
        super(options);
    }
    public SingleChoiceOptionSet(ArrayList<Option> options, boolean isMandatory){
        super(options, isMandatory);
    }
    public SingleChoiceOptionSet(ArrayList<Option> options, String itemListName, String keyVerb){
        super(options, itemListName, keyVerb);
    }
    public SingleChoiceOptionSet(ArrayList<Option> options, String itemListName, String keyVerb, boolean isMandatory){
        super(options, itemListName, keyVerb, isMandatory);
    }

    public Entity getEntity(int index){
        return this.options.get(index).getEntity();
    }

    public int getCost(int index){
        return this.options.get(index).getCost();
    }

    @Override
    public String getDescription(){
        String string = super.getDescription();
        return string.substring(0, string.length() - 1) + " (one choice only):";
    }
}
