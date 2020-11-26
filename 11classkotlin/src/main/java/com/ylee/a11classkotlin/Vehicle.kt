package com.ylee.a11classkotlin

open  class Vehicle {
    private var name : String
    private var speed : Int
    private final var maxspeed : Int
    private final var maxFuelTank : Int
    private var numberOfWheels : Int
    private final var hasABS : Boolean

    constructor(name: String, speed: Int, maxspeed: Int,
                maxFuelTank: Int, numberOfWheels: Int,
                hasABS: Boolean) {
        this.name = name
        this.speed = speed
        this.maxspeed = maxspeed
        this.maxFuelTank = maxFuelTank
        this.numberOfWheels = numberOfWheels
        this.hasABS = hasABS
    }

    open fun sound() : String{
        return "Sound from Vehicle"
    }

    // abstract fun soundabstract()
    open fun soundabstract(){}

}