package scenarioGenerator;

import javax.swing.*;
import java.util.ArrayList;

public class Deployment {
    private String name;
    private ImageIcon img;

    public Deployment(String name, ImageIcon img){
        this.name = name;
        this.img  = img;
    }

    public String getName() {
        return name;
    }

    public ImageIcon getImg() {
        return img;
    }
}
