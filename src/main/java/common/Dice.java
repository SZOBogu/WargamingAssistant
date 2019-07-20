package common;

import java.util.Random;

public class Dice {

    private int max;

    public Dice(){
        this.max = 6;
    }

    public int getMax() {       //merely for tests
        return max;
    }

    public Dice(int max){
        if(max < 1){
            this.max = 6;
        }
        else{
            this.max = max;
        }
    }

    public int roll(){
        Random dice = new Random();
        return (dice.nextInt(this.max) + 1);
    }
}
