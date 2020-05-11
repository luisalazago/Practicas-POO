package UsuarioAdmin

import Servicios._

class UsuarioAdmin extends ServiciosAdmin {
    // Atributos
    private var _cuenta : String = _
    private var _contrasena : String = _

    // Getters
    def cuenta = _cuenta
    def contrasena = _contrasena

    // Setters
    def cuenta_= (nuevaCuenta : String) = _cuenta = nuevaCuenta
    def contrasena_= (nuevaContrasena : String) = _contrasena = nuevaContrasena

    // Métodos
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