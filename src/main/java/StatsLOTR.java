public class StatsLOTR extends Statline{
    public StatsLOTR(String fight, String str, String def, String attacks, String wounds, String courage){
        super();
        Statistic sfight = new Statistic("F", fight);
        Statistic sstr = new Statistic("S", str);
        Statistic sdef = new Statistic("D", def);
        Statistic sattacks = new Statistic("A", attacks);
        Statistic sw = new Statistic("W", wounds);
        Statistic sc = new Statistic("C", courage);
        this.statline.add(sfight);
        this.statline.add(sstr);
        this.statline.add(sdef);
        this.statline.add(sattacks);
        this.statline.add(sw);
        this.statline.add(sc);
    }
}
