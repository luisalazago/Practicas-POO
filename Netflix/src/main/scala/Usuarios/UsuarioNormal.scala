package Usuarios

import Complemento._
import Planes._
import Netfliix._


class UsuarioNormal extends Usuario {

    private var _mora : Boolean = _
    private var _plan : Plan = _
    private var _estado : Boolean = _
    private var _tarjeta : Double = 28.250;
    protected var _descargas : List[Pelicula] = List()

    def this(nuevo_correo : String, nueva_contrasena : String, nuevo_nombre : String, nuevo_plan : Plan) {   
       
        this()
        _nombre = nuevo_nombre
        _correo  = nuevo_correo
        _contrasena = nueva_contrasena
        _mora = false
        _plan = nuevo_plan
        _estado = true
        _plan = null
    }
    

    def getPlan() : Plan = _plan
    def getSaldo() : Double = _tarjeta
    def getMora() : Boolean = _mora
    def getEstado() : Boolean = _estado

    def setPlan(nuevo_plan : Plan ) : Unit = _plan = nuevo_plan    
    def setEstado(nuevo_estado : Boolean) : Unit = _estado = nuevo_estado
    
    def cobroPlan(valor : Double ) : Unit = {

        if (valor <= _tarjeta ) {
            _tarjeta = _tarjeta - valor
        }
    }
    

    def comprarPlan(obj_netflix : Netflix, plan_seleccionado : Plan ) : Netflix = {

        obj_netflix.solicitudCompraPlan(getIdUsuario(), plan_seleccionado)

        return obj_netflix
    }

    def pagarFactura(obj_netflix : Netflix ) : Netflix = {

        obj_netflix.solicitudPagarFactura(getIdUsuario())
        return obj_netflix
    }
    def guardarPelicula(nueva_pelicula : Pelicula ) : Unit = {

        _descargas = nueva_pelicula :: _descargas
    }

    def descargarPelicula(obj_netflix : Netflix, nombre_peli :  String) : Netflix =  { 
        
       obj_netflix.solicitudDescargar(nombre_peli, this.getIdUsuario())

       return  obj_netflix
    }
}