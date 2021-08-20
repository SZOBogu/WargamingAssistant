package scenarioGenerator.pojos;

import java.util.Objects;

public class Deployment {
    private String name;
    private String encodedImage;

    public Deployment(String name){
        this.name = name;
        this.encodedImage = "";
    }

    public Deployment(String name, String img){
        this.name = name;
        this.encodedImage  = img;
    }

    public Deployment(Deployment deployment){
        this(deployment.getName(), deployment.getEncodedImage());
    }

    public String getName() {
        return name;
    }

    public String getEncodedImage() {
        return encodedImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deployment that = (Deployment) o;
        return Objects.equals(name, that.name) && Objects.equals(encodedImage, that.encodedImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, encodedImage);
    }

    @Override
    public String toString() {
        return "Deployment{" +
                "name='" + name + '\'' +
                '}';
    }
}
