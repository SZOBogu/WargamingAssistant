package rosterBuilder.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Table(name = "roster", schema = "wargaming_assistant")
public class Roster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "detachment_id")
    private List<Detachment> detachments;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="primaryArmy_id")
    private Army primaryArmy;

    @Column(name = "pointCap")
    private int pointCap;

    @OneToOne(targetEntity = UniqueEntitiesPool.class, mappedBy = "roster",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private UniqueEntitiesPool uniqueEntitiesPool;

    public Roster(){
        this.detachments = new ArrayList<>();
        this.primaryArmy = null;
        this.pointCap = 0;
        this.uniqueEntitiesPool = new UniqueEntitiesPool();
    }

    public void addDetachment(Detachment detachment){
        this.detachments.add(detachment);
    }

    public void removeDetachment(int index){
       Detachment detachment = this.detachments.get(index);
       for(int i = 0; i < detachment.getDetachmentSlots().size(); i++){      //po detkach
           for (int j = 0; j < detachment.getDetachmentSlots().get(i).getUnits().size(); j++) {  //po kategoriach
               detachment.deleteUnit(i, j, uniqueEntitiesPool);
           }
       }
       this.detachments.remove(index);
    }

    public int size(){
        return this.detachments.size();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Detachment> getDetachments() {
        return detachments;
    }

    public void setDetachments(List<Detachment> detachments) {
        this.detachments = detachments;
    }

    public Army getPrimaryArmy() {
        return primaryArmy;
    }

    public void setPrimaryArmy(Army primaryArmy) {
        this.primaryArmy = primaryArmy;
    }

    public int getPointCap() {
        return pointCap;
    }

    public void setPointCap(int pointCap) {
        this.pointCap = pointCap;
    }

    public UniqueEntitiesPool getUniqueEntitiesPool() {
        return uniqueEntitiesPool;
    }

    public void setUniqueEntitiesPool(UniqueEntitiesPool uniqueEntitiesPool) {
        this.uniqueEntitiesPool = uniqueEntitiesPool;
    }

    @Override
    public String toString(){
        StringBuilder string;
        if(this.primaryArmy != null)
            string = new StringBuilder(this.primaryArmy.getName() + " " + getPointCap() + "p Army\n");
        else
            string = new StringBuilder(getPointCap() + "p Army");
        for(int i = 0; i < this.getDetachments().size(); i++){
            string.append(this.getDetachments().get(i).toString());
        }
        return string.toString();
    }
}
