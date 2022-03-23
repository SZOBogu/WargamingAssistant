package rosterBuilder.entities;

import javax.persistence.*;
import java.util.Objects;

@javax.persistence.Entity
@Table(name = "entity", schema = "wargaming_assistant")
public class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Basic
    @Column(name = "name")
    private String name;

    @Basic
    @Column(name = "description")
    private String description;

    @Basic
    @Column(name = "parameter")
    private String parameter;

    public Entity(){
        this.name = "";
        this.description = "";
        this.parameter = "";
    }
    public Entity(String name, String description){
        this(name, description, "");
    }

    public Entity(String name, String description, String parameter){
        this.name = name;
        this.description = description;
        this.parameter = parameter;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        if(this.parameter.isEmpty()){
            return getName();
        }
        else{
            return getName() + "(" + getParameter() + ")";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
