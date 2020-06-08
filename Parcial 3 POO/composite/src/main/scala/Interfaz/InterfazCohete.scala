package Interfaz

import scala.io._
import scala.util._
import Acoplamiento._

object InterfazCohete extends App {
    var cohete : Cohete = new Cohete
    var estado : Boolean = true
    var componentes : List[Acoplamiento] = List()
    main2()

    def main2() : Unit = {
        while(estado) {
            println("=======================================================")
            println("Bienvenido al programa de misión a Marte :D")
            println("By: Elon Musk")
            println("=======================================================")
            println("1. Crear Piezas")
            println("2. Acoplar Piezas")
            println("3. Descoplar Piezas")
            println("4. Asignar Combustible")
            println("5. Salir")
            println("=======================================================")
            println("¿Qué desea hacer?: ")
            var opcion : Int = StdIn.readInt()

            opcion match {
                case 1 => crearPiezas()
                case 2 => acoplarPiezas()
                case 3 => desacoplicarPiezas()
                case 4 => asignarCombustible()
                case 5 => {
                    println("Hasta la próxima misión!")
                    println("=======================================================")
                    estado = false
                }  
            }
        }
    }

    def crearPiezas() : Unit = {
        println("=======================================================")
        println("Bienvenido a la cración de componentes aeroespaciales")
        println("=======================================================")
        println("1. Crear propulsor EM Drive")
        println("2. Crear Primera Etapa del Cohete")
        println("3. Crear Segunda Etapa del Cohete")
        println("4. Crear Tercera Etapa del Cohete")
        println("5. Volver al menú")
        var opcion : Int = StdIn.readInt()

        opcion match {
            case 1 => {
                var propulsor : EMDrive = new EMDrive
                println("Cuánta fuerza desea darle al motor?:")
                var fuerza : Int = StdIn.readInt()
                propulsor._fuerza = fuerza

                componentes = propulsor::componentes
            }
        }
    }

    def acoplarPiezas() : Unit = {

    }

    def desacoplicarPiezas() : Unit = {

    }

    def asignarCombustible() : Unit = {

    }
}