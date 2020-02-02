package scenarioGenerator;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public class Deployment {
    private String name;
    private ImageIcon img;

    public Deployment(String name, ImageIcon img){
        this.name = name;
        this.img  = img;
    }

    public Deployment(Deployment deployment){
        this(deployment.getName(), deployment.getImg());
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImg() {
        return img;
    }

    //TODO: testy
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deployment that = (Deployment) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(img, that.img);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, img);
    }
}
