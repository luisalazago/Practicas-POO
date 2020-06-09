package Interfaz

import scala.io._
import scala.util._
import Acoplamiento._

object InterfazCohete extends App {
    var cohete : Cohete = new Cohete
    var estado : Boolean = true
    var componentes : List[Acoplamiento] = List()
    var componente1 : PrimeraEtapa = new PrimeraEtapa
    var componente2 : SegundaEtapa = new SegundaEtapa
    var componente3 : TerceraEtapa = new TerceraEtapa
    var componente4 : EMDrive = new EMDrive
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
            println("5. Ver acoplamineto")
            println("6. Salir")
            println("=======================================================")
            println("¿Qué desea hacer?: ")
            var opcion : Int = StdIn.readInt()
            println("=======================================================")

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
                case 5 => verAcoplamiento()
                case 6 => {
                    println("Hasta la próxima misión!")
                    println("=======================================================")
                    estado = false
                    System.exit(0)
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
        println("=======================================================")

        opcion match {
            case 1 => {
                var propulsor : EMDrive = new EMDrive
                println("Cuánta fuerza desea darle al motor?:")
                var fuerza : Int = StdIn.readInt()
                propulsor._fuerza = fuerza

                componentes = propulsor::componentes
                componente4 = propulsor
            }
            case 2 => {
                var primeraEtapa : PrimeraEtapa = new PrimeraEtapa
                println("Cuánta cantidad de combustión desea generar en la primera etapa?")
                var combustion : Double = StdIn.readDouble()
                primeraEtapa._cantCombustion = combustion

                componentes = primeraEtapa::componentes
                componente1 = primeraEtapa
            }
            case 3 => {
                var segundaEtapa : SegundaEtapa = new SegundaEtapa
                println("En cuánto tiempo desea hacer el despliegue de la segunda etapa?")
                var tiempo : Int = StdIn.readInt()
                segundaEtapa._tiempoDespliegue = tiempo

                componentes = segundaEtapa::componentes
                componente2 = segundaEtapa
            }
            case 4 => {
                var terceraEtapa : TerceraEtapa = new TerceraEtapa
                println("Cuánta fuerza de direción desea proporcionar?")
                var fuerzaT : Int = StdIn.readInt()
                terceraEtapa._fuerzaDireccion = fuerzaT

                componentes = terceraEtapa::componentes
                componente3 = terceraEtapa
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
        println("=======================================================")

        var cantidad : Int = 0
        cantidad = cohete._componentes.length
        opcion match {
            case 1 => {
                for(n <- componentes) {
                    if(n == componente1) {
                        cohete.acoplar(n)
                    }
                }
            }
            case 2 => {
                for(n <- componentes) {
                    if(n == componente2) {
                        cohete.acoplar(n)
                    }
                }
            }
            case 3 => {
                for(n <- componentes) {
                    if(n == componente3) {
                        cohete.acoplar(n)
                    }
                }
            }
            case 4 => {
                for(n <- componentes) {
                    if(n == componente4) {
                        cohete.acoplar(n)
                    }
                }
            }
            case 5 => main2()
        }
        if(cantidad == cohete._componentes.length) {
            println("Acoplamiento Fallido")
        }
        else {
            println("Acoplamiento Exitoso!")
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
        println("=======================================================")

        var cantidad : Int = 0
        cantidad = cohete._componentes.length
        opcion match {
            case 1 => {
                for(n <- componentes) {
                    if(n == componente1) {
                        cohete.desacoplar(n)
                    }
                }
            }
            case 2 => {
                for(n <- componentes) {
                    if(n == componente2) {
                        cohete.desacoplar(n)
                    }
                }
            }
            case 3 => {
                for(n <- componentes) {
                    if(n == componente3) {
                        cohete.desacoplar(n)
                    }
                }
            }
            case 4 => {
                for(n <- componentes) {
                    if(n == componente4) {
                        cohete.desacoplar(n)
                    }
                }
            }
            case 5 => main2()
        }
        if(cantidad == cohete._componentes.length) {
            println("Desacoplamiento Fallido")
        }
        else {
            println("Desacoplamiento Exitoso!")
        }

        desacoplicarPiezas()
    }

    def asignarCombustible() : Unit = {
        println("=======================================================")
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
        System.exit(0)
    }

    def verAcoplamiento() : Unit = {
        println("=======================================================")
        println("Bienvenido a la sección de la visualización del acoplamiento")
        println("=======================================================")
        println("A continuación se mostrará las piezas que esan acopladas")
        println("al cóhete con el propósito de ir a Marte")
        println("=======================================================")
        for(n <- cohete._componentes) {
            var acoplado : Boolean = false
            n match {
                case componente1 => {
                    println("Componente: Primera Etapa [Acoplado]")
                    acoplado = true
                } 
                case componente2 => {
                    println("Componente: Segunda Etapa [Acoplado]")
                    acoplado = true
                }
                case componente3 => {
                    println("Componente: Tercera Etapa [Acoplado]")
                    acoplado = true
                }
                case componente4 => {
                    println("Componente: EM Drive [Acoplado]")
                    acoplado = true
                }
            }

            if(!acoplado) {
                n match {
                    case componente1 => {
                    println("Componente: Primera Etapa [Desacoplado]")
                    acoplado = true
                    } 
                    case componente2 => {
                        println("Componente: Segunda Etapa [Desacoplado]")
                        acoplado = true
                    }
                    case componente3 => {
                        println("Componente: Tercera Etapa [Desacoplado]")
                        acoplado = true
                    }
                    case componente4 => {
                        println("Componente: EM Drive [Desacoplado]")
                        acoplado = true
                    }
                }
            }
        }
        println("=======================================================")
        println("Desea volver al menú ? [Y/N]:")
        var opcion : String = StdIn.readLine()

        var estado2 : Boolean = true
        while(estado2) {
            if(opcion == "Y") {
                main2()
            }
            if(opcion == "N") {
                println("Hasta pronto viajero ;)")
                println("==============================")
                estado2 = false
                System.exit(0)
            }
            if(opcion != "Y" || opcion != "N") {
                println("Error")
                println("==============================")
            }
        }
    }
}