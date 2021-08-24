package rosterBuilder.pojos;

import rosterBuilder.pojos.Entity;
import rosterBuilder.pojos.Option;

import java.util.ArrayList;
import java.util.List;

public abstract class OptionSet {
    protected List<Option> options;
    protected String itemListName;
    protected String keyVerb;
    protected boolean isMandatory;

    //TODO: builder
    public OptionSet(List<Option> options){
        this(options, "", "take", false);
    }

    public OptionSet(List<Option> options, boolean isMandatory){
        this(options, "", "take", isMandatory);
    }

    public OptionSet(List<Option> options, String itemListName, String keyVerb){
        this(options, itemListName, keyVerb, false);
    }

    public OptionSet(List<Option> options, String itemListName, String keyVerb, boolean isMandatory){
        this.options = options;
        this.itemListName = itemListName;
        this.keyVerb = keyVerb;
        this.isMandatory = isMandatory;
    }

    public List<Option> getOptions() {
        return options;
    }

    public String getItemListName() {
        return itemListName;
    }

    public String getKeyVerb() {
        return keyVerb;
    }

    public String getDescription(){
        if(itemListName.isEmpty()) {
            if (isMandatory)
                return "Must " + keyVerb + ":";
            else
                return "May " + keyVerb + ":";
        }
        else{
            if (isMandatory)
                return "Must " + keyVerb + " " + itemListName + ":";
            else
                return "May " + keyVerb + " " + itemListName + ":";
        }
    }

    public List<Entity> getAllEntities(){
        List<Entity> entities = new ArrayList<>();
        for (Option option : options) {
            entities.add(option.getEntity());
        }
        return entities;
    }

    public boolean isMandatory() {
        return isMandatory;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
