package es.upsa.a1_prueba1_android_kotlin.pruebas

class PersonNormal(val name: String, val age: Int) // open: la clase puede ser extendida
data class PersonData(val name: String, val age: Int) // open: la clase puede ser extendida

fun main() {
    val p11 = PersonNormal("John", 30)
    val p12 = PersonNormal("John", 30)
    val p21 = PersonData("John", 30)
    val p22 = PersonData("John", 30)

    println("Clase normal: ${p11.toString()}")
    println("Clase data: ${p21.toString()}")

    println("Clase normal (2 igual): ${p11 == p12}") // false (compara referencias de memoria)
    println("Clase data (2 igual): ${p21 == p22}") // true (compara valores, no referencias)
    println("Clase data (3 igual): ${p21 === p22}")

    val p23 = p21.copy(age = 25) // copy() propiedad solo de 'data'
    println("Clase data: ${p23}")

    // Desectructuración (guardar una data class en variables independientes)
    val (name, age) = p21
    print("Clase data: nombre es $name")

}


