package UsuarioAdmin

import Servicios._
import InterfazUsuario._

class UsuarioAdmin(c : String, con : String) {
    // Atributos
    private var _cuenta : String = c
    private var _contrasena : String = con

    // Getters
    def cuenta = _cuenta
    def contrasena = _contrasena

    // Setters
    def cuenta_= (nuevaCuenta : String) = _cuenta = nuevaCuenta
    def contrasena_= (nuevaContrasena : String) = _contrasena = nuevaContrasena   
}