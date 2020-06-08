package Acoplamiento

import scala.util._

class PrimeraEtapa extends Acoplamiento {
    // Atributos
    override var _cantCombustible : Double = _
    var _cantCombustion : Double = _
    var _estadoAcoplado : Boolean = _

    /*Getters*/
    def cantCombustion = _cantCombustion
    def estadoAcoplado = _estadoAcoplado

    /*Setters*/
    def cantCombustion_= (nuevaCombustion : Double) = _cantCombustion = nuevaCombustion
    def estadoAcoplado_= (nuevoEstado : Boolean) = _estadoAcoplado = nuevoEstado

    /*Métdos*/
    def acoplar() : Unit = {
        _estadoAcoplado match {
            case true => _estadoAcoplado = false
            case false => _estadoAcoplado = true
        }
    }
}