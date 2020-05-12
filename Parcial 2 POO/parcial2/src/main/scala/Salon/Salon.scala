package Salon

import Reserva._

class Salon(id : String) {
    // Atributos
    var _estadoLuz : Boolean = false
    var _reservas : List[Reserva] = List(new Reserva(7, 8, "calculo"))
    var _temperatura : Double = 23
    var _ID : String = id 
    var _estadoOcupado : Boolean = false
    var _puerta : Boolean = false
    var _estadoMantenimiento = false

    // Getters
    def ID = _ID

    // Setters
    def ID_= (nuevoID : String) = _ID = nuevoID
}