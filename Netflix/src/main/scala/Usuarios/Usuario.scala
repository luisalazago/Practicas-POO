package Usuarios

import Complemento._
import Planes._
import Netfliix._

import scala.util.Random

class Usuario {
    
    protected var _id_usario : String = generarID()
    protected var _nombre :  String = _
    protected var _correo :  String = _
    protected var _contrasena : String = _
    
    
    /* Getters */

    def getNombre() : String = _nombre
    def getCorreo() : String = _correo
    def getContrasena() : String = _contrasena
    def getIdUsuario() : String = _id_usario

    def generarID() : String = {

        var id : String = Random.alphanumeric.take(10).mkString("")
        
        return id
    }    
    

}
