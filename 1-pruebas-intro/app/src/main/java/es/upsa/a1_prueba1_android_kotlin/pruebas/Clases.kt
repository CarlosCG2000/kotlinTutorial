package es.upsa.a1_prueba1_android_kotlin.pruebas

// _________ Clases __________
// open class Person(name: String, age: Int) // open: la clase puede ser extendida

class Developer(name: String): Person(name, 20) // clase normal que hereda de una clase, pero no se puede extender

abstract class Animal(type: String) // abstract: clase que no se puede instanciar

class Developer2: Person2 { // clase con varios constructores
    constructor(name:String) :  /**Person == super*/ super(name, 20)
    constructor(age:Int) :  /**Person*/ super("John", age)
}

// _________ Properties __________
abstract class Person(val name: String, val age: Int) // si queremos tal cual lo que se pase por parametros

abstract class Person2(name: String, val age: Int) { // si queremos una modificación en el getter del parámetro name
    var name = name
        get() = "Name: $field" // field: para obtener el parámetro que se guarda en la property
        set(value){
            field = "Mr $value"
        }
}

fun main() {
    // _________ Clases __________
//    val p = Person(name = "John", age = 30)
      val d = Developer(name = "Tom")
    // val a = Animal(type="Felino") ❌ No se puede instanciar es una función abstracta
    val d2_1 = Developer2(age=12)
    val d2_2 = Developer2(name="Pepe")
    // _________ Properties __________
    val name = d.name; println(name) // Tom
    val name2 = d2_2.name;  println(name2) // Name: Pepe
    d2_2.name = "Raul"; println(d2_2.name) // Name: Mr Raul

}
