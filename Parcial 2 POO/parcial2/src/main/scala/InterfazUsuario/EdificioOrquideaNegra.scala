package InterfazUsuario

import Servicios._
import Reserva._
import Salon._
import UsuarioAdmin._

class EdificioOrquideaNegra extends ServiciosAdmin with ServiciosSala {
    // Atributos
    var _salas : List[Salon] = List(new Salon("0"))
    var _admins : List[UsuarioAdmin] = List(new UsuarioAdmin("Luis", "123"))
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
        var justo : Int = 60 - _tiempoOnLuz
        if(todos) {
            _tiempoActualMin match {
                case justo => {
                    for(sala <- _salas) {
                        sala._estadoLuz = true
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {

            _tiempoActualMin match {
                case justo => _salas(indice)._estadoLuz = true
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def apagarLuz(indice : Int, todos : Boolean) : Unit = {
        var justo : Int = 60 - _tiempoOffLuz
        if(todos) {
            _tiempoActualMin match {
                case justo => {
                    for(sala <- _salas) {
                        if(sala._estadoOcupado == false) {
                            sala._estadoLuz = false
                        }
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {
            _tiempoActualMin match {
                case justo => _salas(indice)._estadoLuz = false
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def encenderTemperatura(indice : Int, todos : Boolean) : Unit = {
        var justo : Int = 60 - _tiempoOnTemperatura
        if(todos) {
            _tiempoActualMin match {
                case justo => {
                    for(sala <- _salas) {
                        sala._temperatura = 23
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {
            _tiempoActualMin match {
                case justo => _salas(indice)._temperatura = 23
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def apagarTemperatura(indice : Int, todos : Boolean) : Unit = {
        var justo : Int = 60 - _tiempoOffTemperatura
        if(todos) {
            _tiempoActualMin match {
                case justo => {
                    for(sala <- _salas) {
                        if(sala._estadoOcupado == false) {
                            sala._temperatura = 0
                        }
                    }
                }
                case _ => println("Aún no es la hora requerida para ejecutar la acción.") 
            }
        }
        else {
            _tiempoActualMin match {
                case justo => _salas(indice)._temperatura = 0
                case _ => println("Aún no es la hora requerida para ejecutar la acción.")
            }
        }
    }
    def reservar(hora1 : Int, hora2 : Int, materia : String, indice : Int) : Unit = {
        var reserva : Reserva = new Reserva(hora1, hora2, materia)
        var reservaU : Option[Reserva] = _salas(indice)._reservas.filter(n => n._horario1 == reserva._horario1).headOption
        reservaU match {
            case Some(s) => println("Lo siento esta reserva ya está hecha.")
            case None => {
                if(_tiempoActualHora >= _horarioReserva1 && _tiempoActualHora <= _horarioReserva2 && hora1 >= _horarioReserva1 && hora2 <= _horarioReserva2) {
                    _salas(indice)._reservas = reserva :: _salas(indice)._reservas
                    println("Sala reservada exitosamente :)")
                }
                else {
                    println("Lo siento no puede reservar en este horario")
                }
            } 
        }
    }
    def accionPuerta(todos : Boolean, indice : Int, accion: Boolean): Unit = {
        if(todos) {
            accion match {
                case true => _salas.foreach(n => {
                    n._puerta = true
                    n._estadoOcupado = false
                })
                case false => _salas.foreach(n => {
                    n._puerta = false
                    n._estadoOcupado = true
                })
            }
        }
        else {
            accion match {
                case true => {
                    _salas(indice)._puerta = true
                    _salas(indice)._estadoOcupado = false
                } 
                case false => {
                    _salas(indice)._puerta = false
                    _salas(indice)._estadoOcupado = true
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
    def modTimeOnLuz(tiempo : Int) : Int = return tiempo
    def modTimeOffLuz(tiempo : Int) : Int = return tiempo
    def modTimeOpenSalon(tiempo : Int) : Int = return tiempo
    def modTimeOnTemperatura(tiempo : Int) : Int = return tiempo
    def modTimeOffTemperatura(tiempo : Int) : Int = return tiempo
    def modHorarioReserva1(tiempo : Int) : Int = return tiempo
    def modHorarioReserva2(tiempo : Int) : Int = return tiempo
    def habilitarSalon(decision : Boolean) : Boolean = return decision
    def deshabilitarSalon(decision : Boolean) : Boolean = return decision
}