public class StatsT9A_Global extends Statline{
    public StatsT9A_Global(String advance_rate, String march_rate, String discipline) {
        super();
        Statistic advance = new Statistic("Adv", advance_rate);
        Statistic march = new Statistic("Mar", march_rate);
        Statistic dis = new Statistic("Dis", discipline);


        this.statline.add(advance);
        this.statline.add(march);
        this.statline.add(dis);
    }
}
