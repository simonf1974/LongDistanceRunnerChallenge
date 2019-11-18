package io.nology;

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

    public void run(int miles) throws Exception {
        if (isHungry || needsTheLoo) throw new Exception("Can't run if runner is hungry or ");
        int hungryMilesRemainder = milesRun % 10;
        int looMilesRemainder = milesRun % 14;
        if (miles + hungryMilesRemainder >=10) isHungry = true;
        if (miles + looMilesRemainder >=14) needsTheLoo = true;
        reduceEnergy((int) Math.floor(miles / 2));
        milesRun += miles;
    }

    public void eat() {
        isHungry = false;
        reduceEnergy(1);
    }

    public void wee() {
        needsTheLoo = false;
        reduceEnergy(1);
    }

    public void sleep() {
        energy = 10;
        daysSlept += 1;
    }

    private void reduceEnergy(int amount)  {
        energy -= amount;
        if (energy <= 0) isDead = true;
    }
}
