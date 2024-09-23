package example.myapp.codelab3

// Data class Decoration con una propiedad
data class Decoration(val rocks: String)

// Data class Decoration2 con tres propiedades
data class Decoration2(val rocks: String, val wood: String, val diver: String)

fun makeDecorations() {
    // Creación de una instancia de Decoration
    val decoration1 = Decoration("granite")
    println(decoration1)

    // Creación de una instancia de Decoration2
    val d5 = Decoration2("crystal", "wood", "diver")
    println(d5)

    // Asignación de todas las propiedades de Decoration2 a variables
    val (rock, wood, diver) = d5
    println(rock)
    println(wood)
    println(diver)
}

// Enum class Direction con valores y grados
enum class Direction(val degrees: Int) {
    NORTH(0), SOUTH(180), EAST(90), WEST(270)
}

// Función main combinada
fun main() {
    // Llamar a makeDecorations
    makeDecorations()

    // Usar la enum Direction
    println(Direction.EAST.name)
    println(Direction.EAST.ordinal)
    println(Direction.EAST.degrees)
}
