package Salon

import Reserva._

class Salon extends Reserva {
    // Atributos
    var _estadoLuz : Boolean = false
    var _reservas : List[Reserva] = List()
    var _temperatura : Int = 23
    var _ID : String = _ 
    var _estadoOcupado : Boolean = false
    var _puerta : Boolean = false
    var _estadoMantenimiento = false

    // Getters
    def ID = _ID

    // Setters
    def ID_= (nuevoID : String) = _ID = nuevoID
}