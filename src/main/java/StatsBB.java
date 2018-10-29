import java.util.ArrayList;

public class StatsBB extends Statline{
    public StatsBB(String ma, String str, String agi, String av){
        super();
        Statistic sma = new Statistic("MA", ma);
        Statistic sstr = new Statistic("STR", str);
        Statistic sagi = new Statistic("AGI", agi);
        Statistic sav = new Statistic("AV", av);
        this.statline.add(sma);
        this.statline.add(sstr);
        this.statline.add(sagi);
        this.statline.add(sav);
    }
}
