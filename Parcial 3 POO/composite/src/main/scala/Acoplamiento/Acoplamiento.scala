package Acoplamiento

abstract class Acoplamiento {
    // Atributos
    var _cantCombustible : Double

    /*Getters*/
    def cantCombustible = _cantCombustible
    
    /*Setters*/
    def cantCombustible_= (nuevaCantidad : Double) = _cantCombustible = nuevaCantidad

    /*Métodos*/
    def acoplar() : Unit
}