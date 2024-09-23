package codelab2
import java.util.* // required import

fun main(args: Array<String>) {
    println("Hello, mundo")

    // Will assign kotlin.Unit (el resultado de println es Unit)
    val isUnit = println("This is an expression")  // "println" devuelve Unit
    println(isUnit) // Esto imprimirá "kotlin.Unit"

    // Control de temperatura 1
    val temperature = 1
    val isHot = if (temperature > 50) true else false
    println(if (isHot) "true isHot" else "false isNotHot")

    // Control de temperatura 2
    val temperature2 = 10
    val message = "The water temperature is ${if (temperature2 > 50) "too warm" else "OK"}."
    println(message)

    // Llamada a la función feedTheFish
    feedTheFish()

    // Filtrando decoraciones
    println(decorations.filter { it[0] == 'p' })

    // Filtrado eager y lazy
    val eager = decorations.filter { it[0] == 'p' }
    println("eager: $eager")

    val filtered = decorations.asSequence().filter { it[0] == 'p' }
    println("filtered: $filtered")

    // Forzar la evaluación de la lista lazy
    val newList = filtered.toList()
    println("new list: $newList")

    val lazyMap = decorations.asSequence().map {
        println("access: $it")
        it
    }
    println("lazy: $lazyMap")
    println("-----")
    println("first: ${lazyMap.first()}")
    println("-----")
    println("all: ${lazyMap.toList()}")

    val lazyMap2 = decorations.asSequence().filter { it[0] == 'p' }.map {
        println("access: $it")
        it
    }
    println("-----")
    println("filtered: ${lazyMap2.toList()}")

    val mysports = listOf("basketball", "fishing", "running")
    val myplayers = listOf("LeBron James", "Ernest Hemingway", "Usain Bolt")
    val mycities = listOf("Los Angeles", "Chicago", "Jamaica")
    val mylist = listOf(mysports, myplayers, mycities)     // list of lists
    println("-----")
    println("Flat: ${mylist.flatten()}")

    // Uso de updateDirty con lambdas
    var dirtyLevel = 20
    val waterFilter = { dirty: Int -> dirty / 2 }
    println(waterFilter(dirtyLevel))

    fun updateDirty(dirty: Int, operation: (Int) -> Int): Int {
        return operation(dirty)
    }

    // Usar el filtro del agua
    println(updateDirty(30, waterFilter))

    // Otra función para aumentar la suciedad
    fun increaseDirty(start: Int) = start + 1

    println(updateDirty(15, ::increaseDirty))

    // Nueva lógica agregada
    var dirtyLevel2 = 19
    dirtyLevel2 = updateDirty(dirtyLevel2) { dirty -> dirty + 23 }
    println(dirtyLevel2)
}

fun fishFood(day: String): String {
    val food: String = when (day) {
        "Monday" -> "flakes"
        "Tuesday" -> "pellets"
        "Wednesday" -> "redworms"
        "Thursday" -> "granules"
        "Friday" -> "mosquitoes"
        "Saturday" -> "lettuce"
        "Sunday" -> "plankton"
        else -> "fasting" // Valor predeterminado para días no válidos
    }
    return food
}

fun feedTheFish() {
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    println("Change water: ${shouldChangeWater(day)}")
}

fun randomDay(): String {
    val week = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    return week[Random().nextInt(week.size)]
}

fun swim(speed: String = "fast") {
    // Este println muestra el mensaje con el parámetro de velocidad
    println("swimming $speed")
}

fun shouldChangeWater(day: String, temperature: Int = 22, dirty: Int = 20): Boolean {
    return when {
        isTooHot(temperature) -> true
        isDirty(dirty) -> true
        isSunday(day) -> true
        else -> false
    }
}

fun isTooHot(temperature: Int) = temperature > 30

fun isDirty(dirty: Int) = dirty > 30

fun isSunday(day: String) = day == "Sunday"

// Lista de decoraciones
val decorations = listOf("rock", "pagoda", "plastic plant", "alligator", "flowerpot")
