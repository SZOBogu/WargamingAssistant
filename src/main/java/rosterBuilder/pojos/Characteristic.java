package rosterBuilder.pojos;

import java.util.Objects;

public class Characteristic {
    private int characteristicId;
    private final String name;
    private final String value;

    public Characteristic(String name, String value){
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Characteristic characteristic = (Characteristic) o;
        return Objects.equals(name, characteristic.name) &&
                Objects.equals(value, characteristic.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, value);
    }

    @Override
    public String toString() {
        return name + ": " + value;
    }
}
