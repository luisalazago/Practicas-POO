package Acoplamiento

import scala.util._

class TerceraEtapa extends Acoplamiento {
    // Atributos
    override var _cantCombustible : Double = _
    var _fuerzaDireccion : Int = _
    var _estadoAcoplado : Boolean = _

    /*Getters*/
    def fuerzaDireccion = _fuerzaDireccion
    def estadoAcoplado = _estadoAcoplado

    /*Setters*/
    def fuerzaDireccion_= (nuevaFuerza : Int) = _fuerzaDireccion = nuevaFuerza
    def estadoAcoplado_= (nuevoEstado : Boolean) = _estadoAcoplado = nuevoEstado

    /*Métdos*/
    def acoplar() : Unit = {
        _estadoAcoplado match {
            case true => _estadoAcoplado = false
            case false => _estadoAcoplado = true
        }
    }
}