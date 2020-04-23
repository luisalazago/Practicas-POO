package Netfliix

import Usuarios._
import Complemento._
import Planes._

import util.control.Breaks._

class Netflix {
    
    
    /* Atributos */

    private var _peliculas : List[Pelicula] = List()
    private var _usuarios_normales : List[UsuarioNormal] = List()
    private var _usuarios_admin : List[UsuarioAdmin] = List()
    private var _facturas : List[Factura] = List()

    //private var _registros : List[Registro] = List()
    private var _planes : List[String] = List("PREMIUN", "ESTANDAR", "BASICA")

    def getPeliculas() : List[Pelicula] = _peliculas
    def getUsuariosNormales() : List[UsuarioNormal] = _usuarios_normales
    def getUsuariosAdministradores() : List[UsuarioAdmin] = _usuarios_admin
    def getFacturas() : List[Factura] = _facturas

    def setPeliculas(nuevo_catalogo : List[Pelicula] ) : Unit = _peliculas = nuevo_catalogo
    def setUsuariosNormales(nuevo_catalogo : List[UsuarioNormal] ) : Unit = _usuarios_normales = nuevo_catalogo
    def setUsuariosAdministradores(nuevo_catalogo : List[UsuarioAdmin] ) : Unit = _usuarios_admin = nuevo_catalogo
    

    def registroUsuario(nuevo_usuario : UsuarioNormal ) : Unit = {

        _usuarios_normales = nuevo_usuario :: _usuarios_normales
    }

    def registroUsuarioAdmin(nuevo_usuario_admin : UsuarioAdmin ) : Unit = {

        _usuarios_admin = nuevo_usuario_admin :: _usuarios_admin 
    }

    def logeoAdmin(correo : String, contrasena : String ) : UsuarioAdmin = {

        for ( user <- _usuarios_admin) {

            if (user.getNombre() == correo && user.getContrasena() == contrasena ) 
                return user
        }

        return null
    }

    def logeoUsuario(correo : String, contrasena : String ) : UsuarioNormal = {

        for ( user <- _usuarios_normales) {

            if (user.getNombre() == correo && user.getContrasena() == contrasena )
                return user
        }

        return null
    }

    def buscarUsuario(nombre : String ) : Boolean = {

        for (n <- _usuarios_normales) {
            
            if (n.getNombre() == nombre)
                return true
        } 

        for (n <- _usuarios_admin) {
            
            if (n.getNombre() == nombre)
                return true
        } 

        return false
    }

    def buscarPelicula(nombre_pelicula : String ) : Pelicula = {

        for (pelicula <- _peliculas) {
            
            if (pelicula.getNombre() == nombre_pelicula) 
                return pelicula
        }

        return null
    }

    def agregarPelicula(nueva_pelicula : Pelicula) : Unit = {

        _peliculas = nueva_pelicula :: _peliculas
    } 

    def solicitudDescargar(nombre_pelicula : String, id_usuario : String ) : Unit = {

        var pos_usuario : Int = 0
        var band : Boolean = false

        breakable {

            for (usuario <- _usuarios_normales ) {

                if (usuario.getIdUsuario() == id_usuario ) {
                    band = true
                    break
                }
                pos_usuario = pos_usuario + 1
            }
        }

        if (band == true) {

            if (_usuarios_normales(pos_usuario).getEstado() == true) {

                var pos : Int = 0

                _usuarios_normales(pos_usuario).guardarPelicula(buscarPelicula(nombre_pelicula)) 
                _usuarios_normales(pos_usuario)

                breakable {

                    for (factura <- _facturas) {

                        if (factura.getIdCliente() == id_usuario)
                            break

                        pos = pos + 1
                    }
                }

                _facturas(pos).agregarCostoAdicional(7.800)
                _facturas(pos).nuevaDescripcion("Descarga, pelicula " + nombre_pelicula )
            }
        }
    }

    def solicitudCompraPlan(id_usuario : String,  plan_seleccionado : Plan ) : Unit = {

        var pos : Int = 0
        var band : Boolean = false
        var apto_para_comprar = false 

        breakable {

            for(usuario <- _usuarios_normales) {
                        
                if (usuario.getIdUsuario() == id_usuario) {

                    band = true
                    break
                }

                pos = pos + 1 
            }
        }

        if (band == true ) {

            if ( _usuarios_normales(pos).getEstado() == true ) {

                if ( _usuarios_normales(pos).getPlan() == null )
                    apto_para_comprar = true

                else {
                    
                    var pos_factura : Int = 0
                    var band : Boolean = false

                    breakable {
                        
                        for (factura <- _facturas ) {

                            if (factura.getIdCliente() == id_usuario ) {
                                
                                band = true 
                                break
                            }

                            pos_factura = pos_factura + 1
                        }
                    }

                    if (band == true ) {

                        if ( _facturas(pos_factura).getTotal() == 0 ) {
                            apto_para_comprar = true
                        }
                    }
                }
            }
        }  

        if ( band == true && apto_para_comprar == true ) {
            
            /* Aqui se verifica el saldo de la tarjeta */
            //var saldo : Double = _usuarios_normales(pos).getSaldo()
            //var costo : Double = plan_seleccionado.getPrecio()

            //if (saldo >= costo ) {

                _usuarios_normales(pos).setPlan(plan_seleccionado )
                
                var nombre_usuario : String =  _usuarios_normales(pos).getNombre()
                var id_usuario : String =  _usuarios_normales(pos).getIdUsuario() 
                
                generarFactura(id_usuario, nombre_usuario, plan_seleccionado)
                _facturas =  generarFactura(id_usuario, nombre_usuario, plan_seleccionado) :: _facturas 
        
           // }
        }      
    }

    def generarFactura(id_usuario : String, nombre_usuario : String, nuevo_plan : Plan ) : Factura = {

        var nueva_factura : Factura = new Factura(id_usuario, nombre_usuario, nuevo_plan)
    
        return nueva_factura
    }

    def solicitudPagarFactura(id_usuario : String ) : Unit = {
        

        var factura_cancelada : Boolean  =  true
        var pos_factura : Int = 0

        breakable {

            for (factura <- _facturas ) {
                
                if (factura.getIdCliente() == id_usuario && factura.getTotal() > 0 ) {
                    
                    factura_cancelada = false
                    break
                }
                
                pos_factura = pos_factura + 1
            }

        }

        if (factura_cancelada == false ) {

            var band : Boolean = false 
            var pos_usuario : Int = 0

            breakable {

                for (usuario <- _usuarios_normales ) {

                    if (usuario.getIdUsuario() == id_usuario) {

                        band = true
                        break
                    }
                    pos_usuario = pos_usuario + 1
                }
            }

            if (band == true ) {

                var saldo = _usuarios_normales(pos_usuario).getSaldo()
                var total = _facturas(pos_factura).getTotal()

                if ( saldo >= total) {

                    _usuarios_normales(pos_usuario).cobroPlan(total)
                    _facturas(pos_factura).setCancelada(true)
                }
            }
        }
    }


}
