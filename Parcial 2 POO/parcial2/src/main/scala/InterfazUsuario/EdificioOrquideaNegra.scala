package IntefazUsuario

import Servicios._
import Reserva._
import Salon._
import UsuarioAdmon._

class EdificoOrquideaNegra extends ServiciosSala with UsuarioAdmin {
    // Atributos
    var _salas : List[Salon] = List()
    var _admins : List[UsuarioAdmin] = List()
    var _tiempoOnLuz : Int = 5
    var _tiempoOffLuz : Int = 10
    var _tiempoOpenSalon : Int = 15 
    var _tiempoOnTemperatura : Int = 10 
    var _tiempoOffTemperatura : Int = 5 
    var _horarioReserva1 : Int = 7 
    var _horarioReserva2 : Int = 19
    var _esAdmin : Boolean = false
    var _tiempoActualMin : Int = HoraActual.definirHoraActualMin()
    var _tiempoActualHora : Int = HoraActual.definirHoraActualHora()

    // Métodos
    def encenderLuz(indice : Int, todos : Boolean) : Unit = {
        if(todos) {
            _tiempoActual match {
                case 60 - _tiempoOnLuz => {
                    for(sala <- _salas) {
                        sala.estadoLuz = true
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {

            _tiempoActual match {
                case 60 - _tiempoOnLuz => _salas(indice).estadoLuz = true
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def apagarLuz(indice : Int, todos : Boolean) : Unit = {
        if(todos) {
            _tiempoActual match {
                case 60 - _tiempoOffLuz => {
                    for(sala <- _salas) {
                        if(sala.estadoOcupado == false) {
                            sala.estadoLuz = false
                        }
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {
            _tiempoActual match {
                case 60 - _tiempoOffLuz => _salas(indice).estadoLuz = false
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def encenderTemperatura(indice : Int, todos : Boolean) : Unit = {
        if(todos) {
            _tiempoActual match {
                case 60 - _tiempoOnTemperatura => {
                    for(sala <- _salas) {
                        sala.temperatura = true
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {
            _tiempoActual match {
                case 60 - _tiempoOnTemperatura => _salas(indice).temperatura = true
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def apagarTemperatura(indice : Int, todos : Boolean) : Unit = {
        if(todos) {
            _tiempoActual match {
                case 60 - _tiempoOffTemperatura => {
                    for(sala <- _salas) {
                        if(sala.estadoOcupado == false) {
                            sala.temperatura = false
                        }
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {
            _tiempoActual match {
                case 60 - _tiempoOffTemperatura => _salas(indice).temperatura = false
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def reservar(hora1 : Int, hora2 : Int, materia : String, indice : Int) : Unit = {
        var reserva : Reserva = new Reserva(hora1, hora2, materia)
        var reservaU : Option[Reserva] = _salas(indice).reservas.foreach(n => n == reserva).headOption
        reservaU match {
            case Some(s) => println("Lo siento esta reserva ya está hecha.")
            case None => {
                if(_tiempoActualHora >= _horarioReserva1 && _tiempoActualHora <= _horarioReserva2) {
                    _salas(indice).reservas = reserva :: _salas(indice).reservas
                    println("Sala reservada exitosamente :)")
                }
                else {
                    println("Lo siento no puede reservar en este horario")
                }
            } 
        }
    }
    def logeoAdmin(cuenta : String, contrasena : String) : Unit = {
        for(admin <- _admins) {
            if(admin.cuenta == cuenta && admin.contrasena == contrasena) {
                _esAdmin = true
            }
        }
        
        _esAdmin match {
            case true => println("Logeo Exitoso!")
            case false => println("No coinciden las credenciales.")
        }
    } 
}