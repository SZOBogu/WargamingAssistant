import java.util.Objects;

public class Entity {
    private String name;
    private String description;

    public Entity(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(name, entity.name) &&
                Objects.equals(description, entity.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description);
    }
}
