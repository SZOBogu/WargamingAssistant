package rosterBuilder.entities;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "army", schema = "wargaming_assistant")
public class Army {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "scenario_id")
    private List<ArmySubcategory> armySubcategories;

    @Basic
    @Column(name = "img")
    private ImageIcon img;

    @ManyToOne(cascade={CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="main_army_id")
    private Army army;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "ally_id")
    private List<Army> alliableArmyIndexes;

    @OneToOne(targetEntity = Detachment.class, mappedBy = "army",
            cascade = {CascadeType.DETACH, CascadeType.MERGE,
                    CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Detachment detachment;

    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "roster_id")
    private List<Roster> rosters;

    public Army() {
        this("", new ArrayList<>());
    }

    public Army(String name, List<ArmySubcategory> armySubcategories){
        this(name, armySubcategories, new ImageIcon());
    }

    public Army(String name, List<ArmySubcategory> armySubcategories, ImageIcon img ){
        this.name = name;
        this.armySubcategories = armySubcategories;
        this.img = img;
        this.alliableArmyIndexes = new ArrayList<>();
    }

    public ArmySubcategory getArmySubcategory(int index) {
        return armySubcategories.get(index);
    }

    public void setArmySubcategories(ArmySubcategory armySubcategory, int index) {
        this.armySubcategories.set(index, armySubcategory);
    }

    public int size(){
        return this.armySubcategories.size();
    }

    public int getRelevantSlotCount(){
        int counter = 0;
        for(int i = 0; i < this.size(); i++){
            if(this.getArmySubcategory(i).size() > 0){
                counter++;
            }
        }
        return counter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ArmySubcategory> getArmySubcategories() {
        return armySubcategories;
    }

    public void setArmySubcategories(List<ArmySubcategory> armySubcategories) {
        this.armySubcategories = armySubcategories;
    }

    public ImageIcon getImg() {
        return img;
    }

    public void setImg(ImageIcon img) {
        this.img = img;
    }

    public Army getArmy() {
        return army;
    }

    public void setArmy(Army army) {
        this.army = army;
    }

    public List<Army> getAlliableArmyIndexes() {
        return alliableArmyIndexes;
    }

    public void setAlliableArmyIndexes(List<Army> alliableArmyIndexes) {
        this.alliableArmyIndexes = alliableArmyIndexes;
    }

    public Detachment getDetachment() {
        return detachment;
    }

    public void setDetachment(Detachment detachment) {
        this.detachment = detachment;
    }
}
