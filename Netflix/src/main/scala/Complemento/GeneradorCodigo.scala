package Complemento

import scala.util.Random

object GeneradorCodigo {

    def crearCodigoNumerico() : Int = {
        
        var nuevo_codigo : Int =  Random.nextInt(19872332) + 98435216

        return nuevo_codigo
    }

    def crearCodigoAlphaNumerico() : String = {
        
        var nuevo_codigo : String = Random.alphanumeric.take(10).mkString("")

        return nuevo_codigo
    }
}