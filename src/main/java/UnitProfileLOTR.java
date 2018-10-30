import java.util.ArrayList;

public class UnitProfileLOTR extends ModelProfile {
    private StatsLOTR statline;
    private ArrayList<SpecialRule> specialRules;

    public UnitProfileLOTR(Entity entity, StatsLOTR stat, ArrayList<SpecialRule> srs){
        super(entity);
        this.specialRules = srs;        //TODO: move all stats to superclass
        this.statline = stat;
    }

    public Entity getEntity() {
        return super.getEntity();
    }

    public StatsLOTR getStats() {
        return statline;
    }

    public ArrayList<SpecialRule> getSpecialRules() {
        return specialRules;
    }
}
