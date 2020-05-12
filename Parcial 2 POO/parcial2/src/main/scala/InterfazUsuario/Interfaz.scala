package InterfazUsuario

import scala.io._
import Reserva._
import Salon._
import Servicios._
import UsuarioAdmin._
import scala.util._

object Interfaz extends App {
    var paseEdificio : Boolean = true
    var edificio : EdificioOrquideaNegra = new EdificioOrquideaNegra
    main2()

    def main2(): Unit = {
        while(paseEdificio) {
            println("=================================================================")
            println("Bienvenido al edificio Orquídea Negra de la Universidad Javeriana!")
            println("A continuación verá un menú de opciones a realizar para cada salón o en su caso si es Admin.")
            println("=================================================================")
            println("1. Reservar una sala")
            println("2. Mostrar Horario de reservas.")
            println("3. Entrar cómo administrador")
            println("4. Salir del sistema :(")
            var opcion : Int = 0
            opcion.nextLine()
            opcion = StdIn.readInt()

            opcion match {
                case 1 => reservarSala()
                case 2 => imprmirHorario()
                case 3 => logearAdmin()
                case 4 => paseEdificio = false
            }
        }
    }

    def reservarSala() : Unit = {
        println("=================================")
        println("Bienvenido a su reserva de sala!")
        println("Salas disposnibles: ")
        edificio._salas.foreach(n => println(n._ID))
        println("Qué sala desea reservar?")
        var opcion2 : Int = StdIn.readInt()
        var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion2 + "").headOption

        revision match {
            case Some(s) => println("=================================")
            case None =>  {
                println("Sala no encontrada.")
                println("=============================")
                reservarSala()
            }
        }

        println("Digite la hora de partida de la reserva (formato 24 horas):")
        var n : Int = StdIn.readInt()
        var hora1 = n
        println("Ingrese la hora de finalización de la sala (formato 24 horas):")
        n = StdIn.readInt()
        var hora2 = n
        println("Ingrese la materia en la que se va a encontrar en la sala:")
        var m : String = StdIn.readLine()
        edificio.reservar(hora1, hora2, m, opcion2)

        println("=================================")
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => main2()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def imprmirHorario() : Unit = {
        println("=================================")
        println("Bienvenido a la visualización de los horarios!")
        println("Salas disposnibles: ")
        edificio._salas.foreach(n => println(n._ID))
        println("Qué horario de qué sala desea ver? (Ingrese la sala):")
        var opcion2 : Int = StdIn.readInt()
        var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion2 + "").headOption

        revision match {
            case Some(s) => println("=================================")
            case None =>  {
                println("Sala no encontrada.")
                println("=============================")
                imprmirHorario()
            }
        }

        var reser : Int = edificio._salas(opcion2)._reservas.length
        reser match {
            case 0 => println("No hay reservas aún D:")
            case _ => {
                println("El horario de la sala " + opcion2 + " es el siguiente: ")
                edificio._salas(opcion2)._reservas.foreach(n => {
                    println("====================================")
                    println("Hora Inicial: " + n._horario1)
                    println("Hora Finalización: " + n._horario2)
                    println("Materia: " + n._materiaActual)
                    println("====================================")
                })
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => main2()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def logearAdmin() : Unit = {
        if(!edificio._esAdmin) {
            println("==================================")
            println("Ingrese su cuenta:")
            var cuenta : String = StdIn.readLine()
            println("Ingrese su contraseña:")
            var contra : String = StdIn.readLine()

            edificio.logeoAdmin(cuenta, contra)
        }

        if(edificio._esAdmin) {
            var opcion : Boolean = true
            while(opcion) {
                println("==================================================")
                println("Bienvenido al menú de opciones administrativas! :o")
                println("Opciones disponibles: ")
                println("==================================================")
                println("1. Modificar tiempo de encendido de Luz de los salones")
                println("2. Modificar tiempo de apagado de Luz de los salones")
                println("3. Modificar horario de apertura de las puertas")
                println("4. Modificar tiempo de encendido de la temperatura")
                println("5. Modificar tiempo de apagado de la temperatura")
                println("6. Modificar horario disponible de reservas")
                println("7. Modificar horario de finalización de las reservas")
                println("8. Habilitar mantenimiento del salón")
                println("9. Deshabilitar mantenimiento del salón")
                println("10. Encender las luces")
                println("11. Apagar las luces")
                println("12. Encender tempertura.")
                println("13. Apagar temperatura")
                println("14. Abrir puerta(s)")
                println("15. Añadir una sala")
                println("16. Salir de la sesión")
                var opcion2 = StdIn.readInt()

                opcion2 match {
                    case 1 => onLuz()
                    case 2 => offLuz()
                    case 3 => openSalon()
                    case 4 => onTemperatura()
                    case 5 => offTemperatura()
                    case 6 => horarioReserva11()
                    case 7 => horarioReserva22()
                    case 8 => habilitar()
                    case 9 => deshabilitar()
                    case 10 => encenderLuces()
                    case 11 => apagarLuces()
                    case 12 => encenderTemp()
                    case 13 => apagarTemp()
                    case 14 => puerta()
                    case 15 => anadir()
                    case 16 => opcion = false
                }
            }
            println("Vuelva pronto ;)")
            edificio._esAdmin = false
        }
        else {
            println("Error al ingresar los datos")
            logearAdmin()
        }

        println("Volver al menú de opciones? (Y/N)")
        var opcion0 : String = StdIn.readLine()

        opcion0 match {
            case "Y" => main2()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def onLuz() : Unit = {
        println("Tiempo a cambiar:")
        var hora1 = StdIn.readInt()

        edificio._tiempoOnLuz = edificio.modTimeOnLuz(hora1)
        println("Hora cambiada: " + edificio._tiempoOnLuz)
        
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def offLuz() : Unit = {
        println("Hora a cambiar:")
        var hora1 = StdIn.readInt()

        edificio._tiempoOffLuz = edificio.modTimeOffLuz(hora1)
        println("Hora cambiada: " + edificio._tiempoOffLuz)
        
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def openSalon() : Unit = {
        println("Hora a cambiar:")
        var hora1 = StdIn.readInt()

        edificio._tiempoOpenSalon = edificio.modTimeOpenSalon(hora1)
        println("Hora cambiada: " + edificio._tiempoOpenSalon)
        
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def onTemperatura() : Unit = {
        println("Hora a cambiar:")
        var hora1 = StdIn.readInt()

        edificio._tiempoOnTemperatura = edificio.modTimeOnTemperatura(hora1)
        println("Hora cambiada: " + edificio._tiempoOnTemperatura)
        
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def offTemperatura() : Unit = {
        println("Hora a cambiar:")
        var hora1 = StdIn.readInt()

        edificio._tiempoOffTemperatura = edificio.modTimeOffTemperatura(hora1)
        println("Hora cambiada: " + edificio._tiempoOffTemperatura)
        
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def horarioReserva11() : Unit = {
        println("Hora a cambiar:")
        var hora1 = StdIn.readInt()

        edificio._horarioReserva1 = edificio.modHorarioReserva1(hora1)
        println("Hora cambiada: " + edificio._horarioReserva1)
        
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def horarioReserva22() : Unit = {
        println("Hora a cambiar:")
        var hora1 = StdIn.readInt()

        edificio._horarioReserva2 = edificio.modHorarioReserva2(hora1)
        println("Hora cambiada: " + edificio._horarioReserva2)
        
        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def habilitar() : Unit = {
        println("Qué salón desea habilitar el mantenimiento?:")
        edificio._salas.foreach(n => println(n.ID))
        var opcion2 : Int = StdIn.readInt()
        var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion2 + "").headOption

        revision match {
            case Some(s) => println("=================================")
            case None =>  {
                println("Sala no encontrada.")
                println("=============================")
                habilitar()
            }
        }

        edificio._salas(opcion2)._estadoMantenimiento = edificio.habilitarSalon(true)
        println("Salón " + opcion2 + " en mantenimiento")

        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def deshabilitar() : Unit = {
        println("Qué salón desea habilitar el mantenimiento?:")
        edificio._salas.foreach(n => println(n._ID))
        var opcion2 : Int = StdIn.readInt()
        var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion2 + "").headOption

        revision match {
            case Some(s) => println("=================================")
            case None =>  {
                println("Sala no encontrada.")
                println("=============================")
                deshabilitar()
            }
        }


        edificio._salas(opcion2)._estadoMantenimiento = edificio.deshabilitarSalon(false)
        println("Salón " + opcion2 + " en mantenimiento")

        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def encenderLuces() : Unit = {
        println("Desea prender las luces de todos los salones? (Y/N)")
        var opcion1 : String = StdIn.readLine()

        opcion1 match {
            case "Y" => edificio.encenderLuz(0, true)
            case "N" => {
                println("Qué salón desea prenderle la luz?")
                edificio._salas.foreach(n => println(n.ID))
                var opcion3 : Int = StdIn.readInt()
                var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion3 + "").headOption

                revision match {
                    case Some(s) => println("=================================")
                    case None =>  {
                        println("Sala no encontrada.")
                        println("=============================")
                        encenderLuces()
                    }
                }
                edificio.encenderLuz(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def apagarLuces() : Unit = {
        println("Desea apagar las luces de todos los salones? (Y/N)")
        var opcion1 : String = StdIn.readLine()

        opcion1 match {
            case "Y" => edificio.apagarLuz(0, true)
            case "N" => {
                println("Qué salón desea apagarle la luz?")
                edificio._salas.foreach(n => println(n.ID))
                var opcion3 : Int = StdIn.readInt()
                var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion3 + "").headOption

                revision match {
                    case Some(s) => println("=================================")
                    case None =>  {
                        println("Sala no encontrada.")
                        println("=============================")
                        apagarLuces()
                    }
                }
                edificio.apagarLuz(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def encenderTemp() : Unit = {
        println("Desea prender la temperatura de todos los salones? (Y/N)")
        var opcion1 : String = StdIn.readLine()

        opcion1 match {
            case "Y" => edificio.encenderTemperatura(0, true)
            case "N" => {
                println("Qué salón desea prenderle la temperatura?")
                edificio._salas.foreach(n => println(n.ID))
                var opcion3 : Int = StdIn.readInt()
                var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion3 + "").headOption

                revision match {
                    case Some(s) => println("=================================")
                    case None =>  {
                        println("Sala no encontrada.")
                        println("=============================")
                        encenderTemp()
                    }
                }
                edificio.encenderTemperatura(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def apagarTemp() : Unit = {
        println("Desea apagar la temperatura de todos los salones? (Y/N)")
        var opcion1 : String = StdIn.readLine()

        opcion1 match {
            case "Y" => edificio.apagarTemperatura(0, true)
            case "N" => {
                println("Qué salón desea apagarle la temperatura?")
                edificio._salas.foreach(n => println(n.ID))
                var opcion3 : Int = StdIn.readInt()
                var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion3 + "").headOption

                revision match {
                    case Some(s) => println("=================================")
                    case None =>  {
                        println("Sala no encontrada.")
                        println("=============================")
                        apagarLuces()
                    }
                }
                edificio.apagarTemperatura(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        var opcion : String = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }
    def puerta() : Unit = {
        println("Desea abrir o cerrar puertas (Y para abrir/N para cerrar): ")
        var opcion : String = StdIn.readLine()
        if(opcion == "Y") {
            println("Desea abrir todas las puertas de los salones? (Y/N):")
            opcion = StdIn.readLine()
            opcion match {
                case "Y" => {
                    edificio.accionPuerta(true, 0, true)
                    println("Puertas abiertas!")
                }
                case "N" => {
                    println("Qué salón desea abrir?: ")
                    edificio._salas.foreach(n => println(n._ID))
                    var indice : Int = StdIn.readInt()
                    var revision : Option[Salon] = edificio._salas.filter(n => n._ID == indice + "").headOption

                    revision match {
                        case Some(s) => println("=================================")
                        case None =>  {
                            println("Sala no encontrada.")
                            println("=============================")
                            puerta()
                        }
                    }
                    edificio.accionPuerta(false, indice, true)
                    println("Puerta del salón " + indice + " abierta!")
                }
            }
        }
        else {
            println("Desea cerrar todas las puertas de los salones? (Y/N):")
            opcion = StdIn.readLine()
            opcion match {
                case "Y" => {
                    edificio.accionPuerta(true, 0, false)
                    println("Puertas cerradas!")
                }
                case "N" => {
                    println("Qué salón desea cerrar?: ")
                    edificio._salas.foreach(n => println(n._ID))
                    var indice : Int = StdIn.readInt()
                    var revision : Option[Salon] = edificio._salas.filter(n => n._ID == indice + "").headOption

                    revision match {
                        case Some(s) => println("=================================")
                        case None =>  {
                            println("Sala no encontrada.")
                            println("=============================")
                            puerta()
                        }
                    }
                    edificio.accionPuerta(false, indice, false)
                    println("Puerta del salón " + indice + " cerrada!")
                }
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }
    def anadir() : Unit = {
        println("Qué código entre 0 y 50 desea colocarle a la sala:")
        var opcion : String = StdIn.readLine()
        var revision : Option[Salon] = edificio._salas.filter(n => n._ID == opcion).headOption
        revision match {
            case Some(s) => {
                println("Lo sentimos ya existe una sala con ese código.")
                println("Salas existentes:")
                edificio._salas.foreach(n => println("*" + n._ID))
                anadir()
            }
            case None => {
                var salaN : Salon = new Salon(opcion)
                edificio._salas = salaN :: edificio._salas
                println("Sala " + opcion + " fue creada exitosamente!")
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = StdIn.readLine()

        opcion match {
            case "Y" => logearAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }
}