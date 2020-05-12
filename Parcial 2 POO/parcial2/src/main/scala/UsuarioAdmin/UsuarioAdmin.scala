package UsuarioAdmin

import Servicios._
import InterfazUsuario._

class UsuarioAdmin {
    // Atributos
    private var _cuenta : String = _
    private var _contrasena : String = _

    // Getters
    def cuenta = _cuenta
    def contrasena = _contrasena

    // Setters
    def cuenta_= (nuevaCuenta : String) = _cuenta = nuevaCuenta
    def contrasena_= (nuevaContrasena : String) = _contrasena = nuevaContrasena   
}