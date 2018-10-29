public class Stats40k extends Statline{
    public Stats40k(String movement, String weapon_skill, String ballistic_skill, String str, String toughness,
                    String wounds, String attacks, String leadership, String armour_save){
        super();
        Statistic smovement = new Statistic("M", movement);
        Statistic sweapon_skill = new Statistic("WS", weapon_skill);
        Statistic sballistic_skill = new Statistic("BS", ballistic_skill);
        Statistic sstr = new Statistic("S", str);
        Statistic stoughness = new Statistic("T", toughness);
        Statistic swounds = new Statistic("W", wounds);
        Statistic sattacks = new Statistic("A", attacks);
        Statistic sleadership = new Statistic("Ld", leadership);
        Statistic sarmour_save = new Statistic("Sv", armour_save);
        this.statline.add(smovement);
        this.statline.add(sweapon_skill);
        this.statline.add(sballistic_skill);
        this.statline.add(sstr);
        this.statline.add(stoughness);
        this.statline.add(swounds);
        this.statline.add(sattacks);
        this.statline.add(sleadership);
        this.statline.add(sarmour_save);
    }
}
