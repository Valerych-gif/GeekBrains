package ru.geekbrains.valerych.lesson6;

import java.util.Random;

public class Dog extends Animal {

    private static final float VARIATION=0.2f;
    private static final float AVERAGE_RUN_DISTANCE=500.0f;
    private static final float AVERAGE_JUMP_HEIGHT=0.5f;
    private static final float AVERAGE_SWIM_DISTANCE=10.0f;


    Random random=new Random();

    public Dog(String name, String color, int age) {
        super(name, color, age);
        this.maxDistanceOfRun = AVERAGE_RUN_DISTANCE*(0.5f*random.nextFloat()*(1-VARIATION)+(1-VARIATION));
        this.maxHeightOfJump = AVERAGE_JUMP_HEIGHT*(0.5f*random.nextFloat()*(1-VARIATION)+(1-VARIATION));
        this.maxDistanceOfSwim = AVERAGE_SWIM_DISTANCE*(0.5f*random.nextFloat()*(1-VARIATION)+(1-VARIATION));
    }

}