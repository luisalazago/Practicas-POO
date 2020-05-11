package InterfazUsuario

import scala.io._
import Reserva._
import Salon._
import Servicios._
import UsuarioAdmin._

class Interfaz {
    var paseEdificio : Boolean = true
    var edificio : EdificioOrquideaNegra = new EdificioOrquideaNegra
    main()

    def main(): Unit = {
        while(paseEdificio) {
            println("Bienvenido al edificio Orquídea Negra de la Universidad Javeriana!")
            println("A continuación verá un menú de opciones a realizar para cada salón o en su caso si es Admin.")
            println("=================================================================")
            println("1. Reservar una sala")
            println("2. Mostrar Horario de reservas.")
            println("3. Entrar cómo administrador")
            println("4. Salir del sistema :(")
            var opcion : String = Std.readline()

            opcion match {
                case 1 => reservarSala()
                case 2 => imprmirHorario()
                case 3 => logearAdmin()
                case 4 => paseEdificio = false
            }
        }
    }

    def reservarSala() : Unit = {
        println("Bienvenido a su reserva de sala!")
        println("Salas disposnibles: ")
        edificio.salas.foreach(n => println(n.ID))
        println("Qué sala desea reservar?")
        var opcion : String = Std.readline()
        var opcion2 = opcion.asInstanceOf[Int]

        println("Digite la hora de partida de la reserva:")
        var n : String = Std.readline()
        var hora1 = n.asInstanceOf[Int]
        println("Ingrese la hora de finalización de la sala:")
        n = Std.readline()
        var hora2 = n.asInstanceOf[Int]
        println("Ingrese la materia en la que se va a encontrar en la sala:")
        n = Std.readline()
        edificio.reservar(hora1, hora2, n, opcion2)

        println("=================================")
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => main()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def imprmirHorario() : Unit = {
        println("Bienvenido a la visualización de los horarios!")
        println("Salas disposnibles: ")
        edificio.salas.foreach(n => println(n.ID))
        println("Qué horario de qué sala desea ver? (Ingrese la sala):")
        var opcion : String = Std.readline()
        var opcion2 = opcion.asInstanceOf[Int]

        var reser :Int = edificio.salas(opcion2).reservas.length
        reser match {
            case 0 => println("No hay reservas aún D:")
            case _ => {
                println("El horario de la sala " + opcion + " es el siguiente: ")
                edificio.salas(opcion2).reservas.foreach(n => {
                    println("Hora Inicial: " + n.horario1)
                    println("Hora Finalización: " + n.horario2)
                    println("Materia: " + n.materia)
                    println("====================================")
                })
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => main()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def logearAdmin() : Unit = {
        if(!edificio.esAdmin) {
            println("Ingrese su cuenta:")
            var cuenta : String = Std.readline()
            println("Ingrese su contraseña:")
            var contra : String = Std.readline()

            edificio.logeoAdmin(cuenta, contra)
        }

        if(edificio.esAdmin) {
            var opcion : Boolean = true
            while(opcion) {
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
                println("14. Salir de la sesión")
                var opcion1 : String = Std.readline()
                var opcion2 = opcion.asInstanceOf[Int]

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
                    case 14 => opcion = false
                }
            }
            println("Vuelva pronto ;)")
        }
        else {
            println("Error al ingresar los datos")
            logearAdmin()
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => main()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def onLuz() : Unit = {
        println("Hora a cambiar:")
        var hora : String = Std.readline()
        var hora1 = hora.asInstanceOf[Int]

        edifico.tiempoOnLuz = edificio.modTimeOnLuz(hora1)
        println("Hora cambiada: " + edificio.tiempoOnLuz)
        
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def offLuz() : Unit = {
        println("Hora a cambiar:")
        var hora : String = Std.readline()
        var hora1 = hora.asInstanceOf[Int]

        edifico.tiempoOffLuz = edificio.modTimeOffLuz(hora1)
        println("Hora cambiada: " + edificio.tiempoOffLuz)
        
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def openSalon() : Unit = {
        println("Hora a cambiar:")
        var hora : String = Std.readline()
        var hora1 = hora.asInstanceOf[Int]

        edifico.tiempoOpenSalon = edificio.modTimeOpenSalon(hora1)
        println("Hora cambiada: " + edificio.tiempoOpenSalon)
        
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def onTemperatura() : Unit = {
        println("Hora a cambiar:")
        var hora : String = Std.readline()
        var hora1 = hora.asInstanceOf[Int]

        edifico.tiempoOnTemperatura = edificio.modTimeOnTemeperatura(hora1)
        println("Hora cambiada: " + edificio.tiempoOnTemperatura)
        
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def offTemperatura() : Unit = {
        println("Hora a cambiar:")
        var hora : String = Std.readline()
        var hora1 = hora.asInstanceOf[Int]

        edifico.tiempoOffTemperatura = edificio.modTimeOffTemperatura(hora1)
        println("Hora cambiada: " + edificio.tiempoOffTemperatura)
        
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def horarioReserva11() : Unit = {
        println("Hora a cambiar:")
        var hora : String = Std.readline()
        var hora1 = hora.asInstanceOf[Int]

        edifico.horarioReserva1 = edificio.modHorarioReserva1(hora1)
        println("Hora cambiada: " + edificio.horarioReserva1)
        
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def horarioReserva22() : Unit = {
        println("Hora a cambiar:")
        var hora : String = Std.readline()
        var hora1 = hora.asInstanceOf[Int]

        edifico.horarioReserva2 = edificio.modHorarioReserva2(hora1)
        println("Hora cambiada: " + edificio.horarioReserva2)
        
        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def habilitar() : Unit = {
        println("Qué salón desea habilitar el mantenimiento?:")
        edificio.salas.foreach(n => println(n.ID))
        var opcion : String = Std.readline()
        var opcion2 = opcion.asInstanceOf[Int]

        edificio.salas(opcion2).estadoMantenimiento = edificio.habilitarSalon(true)
        println("Salón " + opcion2 + " en mantenimiento")

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def deshabilitar() : Unit = {
        println("Qué salón desea habilitar el mantenimiento?:")
        edificio.salas.foreach(n => println(n.ID))
        var opcion : String = Std.readline()
        var opcion2 = opcion.asInstanceOf[Int]

        edificio.salas(opcion2).estadoMantenimiento = edificio.deshabilitarSalon(false)
        println("Salón " + opcion2 + " en mantenimiento")

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def encenderLuces() : Unit = {
        println("Desea prender las luces de todos los salones? (Y/N)")
        var opcion1 : String = Std.readline()

        opcion1 match {
            case "Y" => edificio.encenderLuz(0, true)
            case "N" => {
                println("Qué salón desea prenderle la luz?")
                edificio.salas.foreach(n => println(n.ID))
                var opcion2 : String = Std.readline()
                var opcion3 = opcion2.asInstanceOf[Int]
                edificio.encenderLuz(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def apagarLuces() : Unit = {
        println("Desea apagar las luces de todos los salones? (Y/N)")
        var opcion1 : String = Std.readline()

        opcion1 match {
            case "Y" => edificio.apagarLuz(0, true)
            case "N" => {
                println("Qué salón desea apagarle la luz?")
                edificio.salas.foreach(n => println(n.ID))
                var opcion2 : String = Std.readline()
                var opcion3 = opcion2.asInstanceOf[Int]
                edificio.apagarLuz(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def encenderTemp() : Unit = {
        println("Desea prender la temperatura de todos los salones? (Y/N)")
        var opcion1 : String = Std.readline()

        opcion1 match {
            case "Y" => edificio.encenderTemperatura(0, true)
            case "N" => {
                println("Qué salón desea prenderle la temperatura?")
                edificio.salas.foreach(n => println(n.ID))
                var opcion2 : String = Std.readline()
                var opcion3 = opcion2.asInstanceOf[Int]
                edificio.encenderTemperatura(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }

    def apagarTemp() : Unit = {
        println("Desea apagar la temperatura de todos los salones? (Y/N)")
        var opcion1 : String = Std.readline()

        opcion1 match {
            case "Y" => edificio.apagarTemperatura(0, true)
            case "N" => {
                println("Qué salón desea apagarle la temperatura?")
                edificio.salas.foreach(n => println(n.ID))
                var opcion2 : String = Std.readline()
                var opcion3 = opcion2.asInstanceOf[Int]
                edificio.apagarTemperatura(opcion3, false)
            }
        }

        println("Volver al menú de opciones? (Y/N)")
        opcion = Std.readline()

        opcion match {
            case "Y" => logeoAdmin()
            case "N" => println("Qué tenga una buen día!")
        }
    }
}