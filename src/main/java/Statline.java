import java.util.ArrayList;
import java.util.Objects;

public class Statline {
    protected ArrayList<Statistic> statline;

    public Statline(){
        this.statline = new ArrayList<Statistic>();
    }
    public ArrayList<Statistic> getStatline(){
        return statline;
    }

    public Statistic getStatistic(int i){
        return this.statline.get(i);
    }
    protected void addStatistic(Statistic stat){
        statline.add(stat);
    }
    public String toString(){
        String string = "";
        for (Statistic stat: this.statline){
            string = string.concat(stat.toString() + " ");
        }
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statline statline1 = (Statline) o;
        return Objects.equals(statline, statline1.statline);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statline);
    }
}
