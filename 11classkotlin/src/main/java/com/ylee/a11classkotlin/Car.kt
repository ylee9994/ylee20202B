package com.ylee.a11classkotlin

class Car : Vehicle {
    var engineType : String

    constructor(name: String, speed: Int, maxspeed: Int,
                maxFuelTank: Int, numberOfWheels: Int,
                hasABS: Boolean, engineType: String) :
            super(name, speed, maxspeed, maxFuelTank,
                    numberOfWheels, hasABS) {
        this.engineType = engineType
    }

    override fun sound(): String {
        return "Sound from Car"
    }

    override fun soundabstract() {

    }
}