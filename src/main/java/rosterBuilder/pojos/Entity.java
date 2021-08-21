package rosterBuilder.pojos;

import java.util.Objects;

public class Entity {
    private final String name;
    private final String description;
    private String parameter;

    public Entity(String name, String description){
        this(name, description, "");
    }

    public Entity(String name, String description, String parameter){
        this.name = name;
        this.description = description;
        this.parameter = parameter;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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
