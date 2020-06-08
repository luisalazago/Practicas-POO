package Acoplamiento

import scala.util._

class SegundaEtapa extends Acoplamiento {
    // Atributos
    override var _cantCombustible : Double = _
    var _tiempoDespliegue : Int = _
    var _estadoAcoplado : Boolean = _

    /*Getters*/
    def tiempoDespliegue = _tiempoDespliegue
    def estadoAcoplado = _estadoAcoplado

    /*Setters*/
    def tiempoDespliegue_= (nuevoTiempo : Int) = _tiempoDespliegue = nuevoTiempo
    def estadoAcoplado_= (nuevoEstado : Boolean) = _estadoAcoplado = nuevoEstado

    /*Métdos*/
    def acoplar() : Unit = {
        _estadoAcoplado match {
            case true => _estadoAcoplado = false
            case false => _estadoAcoplado = true
        }
    }
}