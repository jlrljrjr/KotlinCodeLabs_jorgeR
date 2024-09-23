package example.myapp

import java.lang.Math.PI

// Clase base Aquarium
open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40) {
    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    init {
        println("Aquarium initializing")
    }

    init {
        println("Volume: ${width * length * height / 1000} liters")
    }

    constructor(numberOfFish: Int) : this() {
        val tank = numberOfFish * 2000 * 1.1
        height = (tank / (length * width)).toInt()
    }

    open var volume: Int
        get() = width * height * length / 1000
        set(value) {
            height = (value * 1000) / (width * length)
        }

    fun printSize() {
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")
        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

// Clase derivada TowerTank
class TowerTank(override var height: Int, var diameter: Int) : Aquarium(height = height, width = diameter, length = diameter) {
    override var volume: Int
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value) {
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    override var water = volume * 0.8
    override val shape = "cylinder"
}

// Función para crear instancias de Aquarium y TowerTank
fun buildAquarium() {
    val myAquarium = Aquarium(width = 25, length = 25, height = 40)
    myAquarium.printSize()
    val myTower = TowerTank(diameter = 25, height = 40)
    myTower.printSize()

    val aquarium1 = Aquarium()
    aquarium1.printSize()

    val aquarium2 = Aquarium(width = 25)
    aquarium2.printSize()

    val aquarium3 = Aquarium(height = 40, length = 25)
    aquarium3.printSize()

    val aquarium4 = Aquarium(length = 25, width = 25, height = 40)
    aquarium4.printSize()

    val aquarium5 = Aquarium(numberOfFish = 29)
    aquarium5.printSize()

    val towerTank = TowerTank(height = 40, diameter = 25)
    towerTank.printSize()
}

fun main() {
    buildAquarium()
}
