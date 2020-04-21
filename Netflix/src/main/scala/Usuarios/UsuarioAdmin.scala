package Usuarios

import Netfliix._
import Complemento._
import Planes._

import util.control.Breaks._


class UsuarioAdmin extends Usuario {

    
    def this(nuevo_correo : String, nueva_contrasena : String, nuevo_nombre : String) {   
       
        this()
        _nombre = nuevo_nombre
        _correo  = nuevo_correo
        _contrasena = nueva_contrasena
    }

    def agregarPelicula(obj_netflix : Netflix, nueva_pelicula : Pelicula ) : Netflix = {

        obj_netflix.agregarPelicula(nueva_pelicula)

        return obj_netflix
    }

    def eliminarPelicula(obj_netflix : Netflix, nombre_pelicula : String ) : Netflix = {

        var nuevo_catalogo : List[Pelicula] = List()

        for (pelicula <- obj_netflix.getPeliculas() ) {

            if (pelicula.getNombre() != nombre_pelicula) {
               nuevo_catalogo = pelicula :: nuevo_catalogo
            }
        }
    
        obj_netflix.setPeliculas(nuevo_catalogo)
        
        return  obj_netflix
    } 

    def eliminarUsuario(obj_netflix : Netflix, nombre_usuario :  String ) : Netflix = {
        
        var nuevo_catalogo : List[UsuarioNormal] =  List()

        breakable {

            for (usuario <- obj_netflix.getUsuariosNormales() ) {
                
                var meses_en_mora : Int = verificarPago(obj_netflix, nombre_usuario)
                
                if ( !( (usuario.getNombre() ==  nombre_usuario) && (meses_en_mora >= 4) ) ) {    
                    nuevo_catalogo = usuario :: nuevo_catalogo
                }

            }

        }

        obj_netflix.setUsuariosNormales(nuevo_catalogo)

        return obj_netflix

    }

    def inhabilitarUsuario(obj_netflix : Netflix, nombre_usuario : String ) : Netflix = {

        breakable {

            for (usuario <- obj_netflix.getUsuariosNormales()  ) {

                var meses_en_mora : Int = verificarPago(obj_netflix, nombre_usuario)
                
                if ( (usuario.getNombre() ==  nombre_usuario) && (meses_en_mora >= 2  && meses_en_mora < 4 ) ) {
                    usuario.setEstado(true)
                    break
                }
            }

        }

        return obj_netflix
    } 
    
    def verificarPago(obj_netflix : Netflix, nombre_usuario : String ) : Int = {

        /* Sólo verifica si el usuario esta en mora */
        
        var fecha_actual : String = "" + java.time.LocalDate.now
        var meses_en_mora : Int = 0

        breakable {

            for (usuario <- obj_netflix.getUsuariosNormales() ) {

                if (usuario.getNombre() == nombre_usuario ) {
                    
                    for (factura <- obj_netflix.getFacturas() ) {

                        if (factura.getIdCliente() == usuario.getIdUsuario() ) {

                            var fecha_vencimiento : String = factura.getFechaVencimiento()
                            var mes_vencimiento : Int = ("" + fecha_vencimiento.charAt(5) + "" + fecha_vencimiento.charAt(6) + "").toInt
                            
                            var fecha_actual : String = ("" + java.time.LocalDate.now)
                            var mes_actual : Int = ("" + fecha_actual.charAt(5) + "" + fecha_actual.charAt(6) + "").toInt


                            if ( mes_actual != mes_vencimiento ) {

                                meses_en_mora = (12 - mes_actual) + mes_vencimiento
                                
                                if (meses_en_mora > 12 && mes_actual < mes_vencimiento )  {

                                    meses_en_mora = meses_en_mora - 12
                                }
                            }

                            else {

                                meses_en_mora = 0
                            }
                            
                            return meses_en_mora
                        }
                    }
                } 
            }
        }

        return meses_en_mora
    }
    
    def peliculasMasVistas(obj_netflix : Netflix ) : List[Pelicula] = {

        var peliculas_top :  List[Pelicula] = List()

        peliculas_top =  obj_netflix.getPeliculas()
        peliculas_top.sortWith(_.getVistas() > _.getVistas())

        return peliculas_top
    }

    def peliculasMenosVistas(obj_netflix : Netflix ) : List[Pelicula] = {

        var peliculas_no_top :  List[Pelicula] = List()

        peliculas_no_top =  obj_netflix.getPeliculas()
        peliculas_no_top.sortWith(_.getVistas() < _.getVistas())

        return peliculas_no_top
    }


    def crearUsuarioAdministrativo(obj_netflix : Netflix, nuevo_adim : UsuarioAdmin ) : Netflix = {

        obj_netflix.registroUsuarioAdmin(nuevo_adim )

        return obj_netflix     
    } 

}