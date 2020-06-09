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
                case 1 => {
                    if(componentes.length < 4) {
                        crearPiezas()
                    }
                    println("Lo siento todas las piezas para el cohete están hechas :(")
                    println("=======================================================")
                    main2()
                }
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
            case 2 => {
                var primeraEtapa : PrimeraEtapa = new PrimeraEtapa
                println("Cuánta cantidad de combustión desea generar en la primera etapa?")
                var combustion : Double = StdIn.readDouble()
                primeraEtapa._cantCombustion = combustion

                componentes = primeraEtapa::componentes
            }
            case 3 => {
                var segundaEtapa : SegundaEtapa = new SegundaEtapa
                println("En cuánto tiempo desea hacer el despliegue de la segunda etapa?")
                var tiempo : Int = StdIn.readInt()
                segundaEtapa._tiempoDespliegue = tiempo

                componentes = segundaEtapa::componentes
            }
            case 4 => {
                var terceraEtapa : TerceraEtapa = new TerceraEtapa
                println("Cuánta fuerza de direción desea proporcionar?")
                var fuerzaT : Int = StdIn.readInt()
                terceraEtapa._fuerzaDireccion = fuerzaT

                componentes = terceraEtapa::componentes
            }
            case 5 => main2()
        }
        crearPiezas()
    }

    def acoplarPiezas() : Unit = {
        println("=======================================================")
        println("Bienvenido al menú de acoplamiento!")
        println("=======================================================")
        println("1. Acoplar la primera fase")
        println("2. Acoplar la segunda fase")
        println("3. Acoplar la tercera fase")
        println("4. Acoplar el propulsor EM Drive")
        println("5. Volver al menú")
        var opcion : Int = StdIn.readInt()

        opcion match {
            case 1 => {
                for(n <- componentes) {
                    var temp : Try[PrimeraEtapa] = n
                    temp match {
                        case Success(s) => cohete.acoplar(s)
                        case Failure(f) => println("Buscando...") 
                    }
                }
            }
            case 2 => {
                for(n <- componentes) {
                    var temp2 : Try[SegundaEtapa] = n
                    temp2 match {
                        case Success(s) => cohete.acoplar(s)
                        case Failure(f) => println("Buscando...")
                    }
                }
            }
            case 3 => {
                for(n <- componentes) {
                    var temp3 : Try[TerceraEtapa] = n
                    temp3 match {
                        case Success(s) => cohete.acoplar(s)
                        case Failure(f) => println("Buscando...")
                    }
                }
            }
            case 4 => {
                for(n <- componentes) {
                    var temp4 : Try[EMDrive] = n
                    temp4 match {
                        case Success(s) => cohete.acoplar(s)
                        case Failure(f) => println("Buscando...") 
                    }
                }
            }
            case 5 => main2()
        }
        acoplarPiezas()
    }

    def desacoplicarPiezas() : Unit = {
        println("=======================================================")
        println("Bienvenido al menú de desacoplamiento!")
        println("=======================================================")
        println("1. Desacoplar la primera fase")
        println("2. Desacoplar la segunda fase")
        println("3. Desacoplar la tercera fase")
        println("4. Desacoplar el propulsor EM Drive")
        println("5. Volver al menú")
        var opcion : Int = StdIn.readInt()

        opcion match {
            case 1 => {
                for(n <- cohete._componentes) {
                    var temp : Try[PrimeraEtapa] = n
                    temp match {
                        case Success(s) => cohete.desacoplar(s)
                        case Failure(f) => println("Buscando...") 
                    }
                }
            }
            case 2 => {
                for(n <- cohete._componentes) {
                    var temp2 : Try[SegundaEtapa] = n
                    temp2 match {
                        case Success(s) => cohete.desacoplar(s)
                        case Failure(f) => println("Buscando...")
                    }
                }
            }
            case 3 => {
                for(n <- cohete._componentes) {
                    var temp3 : Try[TerceraEtapa] = n
                    temp3 match {
                        case Success(s) => cohete.desacoplar(s)
                        case Failure(f) => println("Buscando...")
                    }
                }
            }
            case 4 => {
                for(n <- cohete._componentes) {
                    var temp4 : Try[EMDrive] = n
                    temp4 match {
                        case Success(s) => cohete.desacoplar(s)
                        case Failure(f) => println("Buscando...") 
                    }
                }
            }
            case 5 => main2()
        }
        desacoplicarPiezas()
    }

    def asignarCombustible() : Unit = {
        println("Cuánta cantidad de Combustible desea asignar?")
        var cantidad : Int = StdIn.readInt()

        if(componentes.length > 0) {
            for(n <- componentes) {
                n._cantCombustible = cantidad
            }
            
            if(cohete._componentes.length > 0) {
                for(n <- cohete._componentes) {
                    n._cantCombustible = cantidad
                }
            }
        }
        else {
            println("No hay componentes para asignar combustible :(")
        }
        
        var estado2 : Boolean = true
        while(estado2) {
            println("Desea volver al menú? [Y/N]:")
            var opcion : String = StdIn.readLine()

            if(opcion == "Y") {
                main2()
            }
            if(opcion == "N") {
                estado2 = false
            }
            if(opcion != "Y" || opcion != "N") {
                println("Error")
                println("==============================")
            }
        }
        println("Vuelva Pronto ;)")
        println("==============================")
    }
}