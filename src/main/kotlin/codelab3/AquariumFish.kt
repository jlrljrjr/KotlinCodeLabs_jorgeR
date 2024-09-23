package example.myapp.codelab3

abstract class AquariumFish : FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}
class Shark: FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

class Plecostomus (fishColor: FishColor = GoldColor):
    FishAction by PrintingFishAction("eat algae"),
    FishColor by fishColor

class PrintingFishAction(val food: String) : FishAction {
    override fun eat() {
        println(food)
    }
}

fun makeFish() {
    val shark = Shark()
    val pleco = Plecostomus()
    println("Shark: ${shark.color}")
    shark.eat()
    println("Plecostomus: ${pleco.color}")
    pleco.eat()
}

fun main () {
    makeFish()
}
interface FishAction  {
    fun eat()
}
interface FishColor {
    val color: String
}
object GoldColor : FishColor {
    override val color = "gold"
}
