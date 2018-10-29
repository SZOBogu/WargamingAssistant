public class StatsLOTR_Hero extends StatsLOTR{
    /*
        From army building (therefore users) perspective Might, Will and Fate are very importanat, and it's sensless to
        include those 3 into regular units statlines. So I'm making Hero's statline a new class
     */
    public StatsLOTR_Hero(String fight, String str, String def, String attacks, String wounds, String courage,
                          String might, String will, String fate){
        super(fight, str, def, attacks, wounds, courage);
        Statistic m = new Statistic("Might", might);
        Statistic w = new Statistic("Will", will);
        Statistic f = new Statistic("Fate", fate);
        this.statline.add(m);
        this.statline.add(w);
        this.statline.add(f);
    }
    @Override
    public String toString(){
        String string = super.toString();
        int index =string.indexOf('M');        //Capital M in this statline is only in word "Might",
                                                // and i want new line before it.
        int len = string.length();
        string = string.substring(0, index - 1) + "\n" + string.substring(index, len);
        string.concat("\n");
        return string;
    }
}
