import java.util.ArrayList;

public class ModelProfileT9A extends ModelProfile {
    private StatsT9A_Global globalStats;
    private StatsT9A_Offensive offensiveStats;
    private StatsT9A_Defensive defensiveStats;
    private ArrayList<SpecialRule> specialRules;

    public ModelProfileT9A(Entity entity, StatsT9A_Global globlas, StatsT9A_Offensive offensives,
                           StatsT9A_Defensive defensives, ArrayList<SpecialRule> specials){
        super(entity);
        this.globalStats = globlas;
        this.defensiveStats = defensives;
        this.offensiveStats = offensives;
        this.specialRules = specials;
    }

    public StatsT9A_Global getGlobalStats() {
        return globalStats;
    }

    public StatsT9A_Offensive getOffensiveStats() {
        return offensiveStats;
    }

    public StatsT9A_Defensive getDefensiveStats() {
        return defensiveStats;
    }

    public ArrayList<SpecialRule> getSpecialRules() {
        return specialRules;
    }
}
