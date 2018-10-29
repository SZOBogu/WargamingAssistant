public class StatsT9A_Defensive extends Statline{
    public StatsT9A_Defensive(String HP, String defensive_skill, String resilience, String armour) {
        super();
        Statistic hp = new Statistic("HP", HP);
        Statistic def = new Statistic("Def", defensive_skill);
        Statistic res = new Statistic("Res", resilience);
        Statistic arm = new Statistic("Arm", armour);

        this.statline.add(hp);
        this.statline.add(def);
        this.statline.add(res);
        this.statline.add(arm);
    }
}
