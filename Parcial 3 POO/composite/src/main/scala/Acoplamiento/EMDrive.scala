package Acoplamiento

import scala.util._

class EMDrive extends Acoplamiento {
    // Atributos
    override var _cantCombustible : Double = 0
    var _fuerza : Int = _
    var _estadoAcoplado : Boolean = _

    /*Getters*/
    def fuerza = _fuerza
    def estadoAcoplado = _estadoAcoplado

    /*Setters*/
    def fuerza_= (nuevaFuerza : Int) = _fuerza = nuevaFuerza
    def estadoAcoplado_= (nuevoEstado : Boolean) = _estadoAcoplado = nuevoEstado

    /*Métdos*/
    def acoplar() : Unit = {
        _estadoAcoplado match {
            case true => _estadoAcoplado = false
            case false => _estadoAcoplado = true
        }
    }
}