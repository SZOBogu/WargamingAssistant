public class Stats40kWeapon extends Statline{
    public Stats40kWeapon(String range, String type, String str, String ap, String dmg){
        super();
        Statistic srang = new Statistic("Range", range);
        Statistic stype= new Statistic("Type", type);
        Statistic sstr = new Statistic("S", str);
        Statistic sap = new Statistic("AP", ap);
        Statistic sd = new Statistic("D", dmg);
        this.statline.add(srang);
        this.statline.add(stype);
        this.statline.add(sstr);
        this.statline.add(sap);
        this.statline.add(sd);
    }
    @Override
    //TODO: additional tab after Type
    public String toString(){
        String string = "";
        for (Statistic stat: this.statline){
            string = string.concat(stat.getName() + "\t");
        }
        string = string.concat("\n");
        for (Statistic stat: this.statline){
            string = string.concat(stat.getValue() + "\t");
        }
        return string;
    }
}
