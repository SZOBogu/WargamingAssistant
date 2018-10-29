public class StatsT9A_Offensive extends Statline{
    public StatsT9A_Offensive(String attacks, String offensive_skill, String str, String ap, String agility) {
        super();
        Statistic att = new Statistic("Att", attacks);
        Statistic off = new Statistic("Off", offensive_skill);
        Statistic st = new Statistic("Str", str);
        Statistic armp = new Statistic("AP", ap);
        Statistic agi = new Statistic("Agi", agility);

        this.statline.add(att);
        this.statline.add(off);
        this.statline.add(st);
        this.statline.add(armp);
        this.statline.add(agi);
    }
}
