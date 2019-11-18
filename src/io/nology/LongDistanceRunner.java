package io.nology;

import com.google.common.math.IntMath;


import java.math.BigDecimal;
import java.math.RoundingMode;

public class LongDistanceRunner {
    private int energy;
    private int milesRun;
    private int daysSlept;
    private boolean isHungry;
    private boolean needsTheLoo;
    private boolean isDead;

    public LongDistanceRunner() {
        energy = 10;
        milesRun = 0;
        daysSlept = 0;
        isHungry = false;
        needsTheLoo = false;
        isDead = false;
    }

    public boolean isDead() {
        return isDead;
    }

    public String run(int miles) {
        if (isHungry || needsTheLoo) return "Can't run if runner is hungry or needs the loo \n" + toString();
        int hungryMilesRemainder = milesRun % 10;
        int looMilesRemainder = milesRun % 14;
        if (miles + hungryMilesRemainder >=10) isHungry = true;
        if (miles + looMilesRemainder >=14) needsTheLoo = true;
        reduceEnergy(IntMath.divide(miles, 2, RoundingMode.UP));
        milesRun += miles;
        return toString();
    }

    public String eat() {
        isHungry = false;
        reduceEnergy(1);
        return toString();
    }

    public String wee() {
        needsTheLoo = false;
        reduceEnergy(1);
        return toString();
    }

    public String sleep() {
        energy = 10;
        daysSlept += 1;
        return toString();
    }

    private void reduceEnergy(int amount)  {
        energy -= amount;
        if (energy <= 0) isDead = true;
    }

    @Override
    public String toString() {
        return "LongDistanceRunner{" +
                "energy=" + energy +
                ", milesRun=" + milesRun +
                ", daysSlept=" + daysSlept +
                ", isHungry=" + isHungry +
                ", needsTheLoo=" + needsTheLoo +
                ", isDead=" + isDead +
                '}';
    }
}
