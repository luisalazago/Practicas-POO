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
    protected var _descargas : List[Pelicula] = List()
    
    /* Getters */

    def getNombre() : String = _nombre
    def getCorreo() : String = _correo
    def getContrasena() : String = _contrasena
    def getIdUsuario() : String = _id_usario

    def generarID() : String = {

        var id : String = Random.alphanumeric.take(10).mkString("")
        
        return id
    }    
    

    def descargarPelicula(nombre_peli :  String) : Unit =  { 
        
       // Netflix.solicitudDescarga(nombre_peli, _id_usario)
    }

   def guardarPelicula(nueva_pelicula : Pelicula ) : Unit = {

        _descargas = nueva_pelicula :: _descargas
    }
}
