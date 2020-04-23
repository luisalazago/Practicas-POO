package Usuarios

import Complemento._
import Planes._
import Netfliix._


class Usuario {
    
    protected var _id_usario : String = GeneradorCodigo.crearCodigoAlphaNumerico()
    protected var _nombre :  String = _
    protected var _correo :  String = _
    protected var _contrasena : String = _
    
    /* Setters */
    
    def setNombre(nuevo_nombre : String ) : Unit = _nombre = nuevo_nombre
    def setCorreo(nuevo_correo : String ) : Unit = _correo = nuevo_correo
    def setContrasena(nueva_contrasena : String ) : Unit = _contrasena = nueva_contrasena

    /* Getters */

    def getNombre() : String = _nombre
    def getCorreo() : String = _correo
    def getContrasena() : String = _contrasena
    def getIdUsuario() : String = _id_usario

    /* En proceso */
    
    def verPeliula() : Unit = {

    }

}
