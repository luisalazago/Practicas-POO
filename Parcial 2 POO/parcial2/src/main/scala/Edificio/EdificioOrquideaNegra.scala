package Edifico

import Servicios._
import Reserva._
import Salon._
import UsuarioAdmon._

class EdificoOrquideaNegra {
    // Atributos
    var _salas : List[Salon] = List()
    var _tiempoOnLuz : Int = _
    var _tiempoOffLuz : Int = _
    var _tiempoOpenSalon : Int = _ 
    var _tiempoOnTemperatura : Int = _ 
    var _tiempoOffTemperatura : Int = _ 
    var _horarioReserva1 : Int = _ 
    var _horarioReserva2 : Int = _ 
    var _esAdmin : Boolean = false

    // Getters
    def tiempoOnLuz = _tiempoOnLuz
    def tiempoOffLuz = _tiempoOffLuz
    def tiempoOpenSalon = _tiempoOpenSalon
    def tiempoOnTemperatura = _tiempoOnTemperatura
    def tiempoOffTemperatura = _tiempoOffTemperatura
    def horarioReserva1 = _horarioReserva1
    def horarioReserva2 = _horarioReserva2

    // Setters 
    def tiempoOnLuz_= (nuevoTiempo : Int) = _tiempoOnLuz = nuevoTiempo
    def tiempoOffLuz_= (nuevoTiempo : Int) = _tiempoOffLuz = nuevoTiempo
    def tiempoOpenSalon_= (nuevoTiempo : Int) = _tiempoOpenSalon = nuevoTiempo
    def tiempoOnTemperatura_= (nuevoTiempo : Int) = _tiempoOnTemperatura = nuevoTiempo
    def tiempoOffTemperatura_= (nuevoTiempo : Int) = _tiempoOffTemperatura = nuevoTiempo
    def horarioReserva1_= (nuevoHorario : Int) = _horarioReserva1 = nuevoHorario
    def horarioReserva2_= (nuevoHorario : Int) = _horarioReserva2 = nuevoHorario

    // Métodos.
}