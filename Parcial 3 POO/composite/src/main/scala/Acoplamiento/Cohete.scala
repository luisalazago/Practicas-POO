package Acoplamiento

import scala.util._

class Cohete extends Acoplamiento {
    // Atributos
    override var _cantCombustible : Double = _
    override var _estadoAcoplado : Boolean = false
    var _componentes : List[Acoplamiento] = List()

    /*Getters*/
    def estadoAcoplado = _estadoAcoplado

    /*Setters*/
    def estadoAcoplado_= (nuevoEstado : Boolean) = _estadoAcoplado = nuevoEstado

    /*Métodos*/
    def acoplar(componente : Acoplamiento) : Unit = _componentes = componente::_componentes
    def desacoplar(componente : Acoplamiento) : Unit = {
        var temp : List[Acoplamiento] = List()
        for(n <- _componentes) {
            if(n != componente) {
                temp = n::temp
            }
        }
        _componentes = temp
    }
    def acoplar() : Unit = {
        _estadoAcoplado match {
            case true => _estadoAcoplado = false
            case false => _estadoAcoplado = true
        }
    }
}