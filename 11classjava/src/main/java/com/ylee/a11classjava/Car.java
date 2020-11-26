package com.ylee.a11classjava;

public  class Car extends Vehicle {
    private final String engineType;

    public Car(String name, int speed, int maxspeed,
               int maxFuelTank, int numberOFWheels,
               boolean hasABS, String engineType) {
        super(name, speed, maxspeed, maxFuelTank,
                numberOFWheels, hasABS);
        this.engineType = engineType;
    }

    @Override
    public String sound() {
        return "Sound from Car";
    }

    @Override
    public String soundabstract() {
        return "abstract sound from Car";
    }
}
