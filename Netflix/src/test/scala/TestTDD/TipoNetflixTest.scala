import org.scalatest.FunSuite

import Netfliix._
import Complemento._
import Planes._
import Usuarios._

class TipoNetflixTest extends FunSuite {

    var tipo_Netflix : Netflix = new Netflix()

    var plan_1 : Plan = new Plan("PREMIUN")
    var plan_2 : Plan = new Plan("ESTANDAR")
    var plan_3 : Plan = new Plan("BASICO")

    var cliente_1 : UsuarioNormal = new UsuarioNormal( "salazar@comp.org", "0123luis", "Luis Salazar", plan_1 )
    var cliente_2 : UsuarioNormal = new UsuarioNormal( "geiler@tepl.org", "0123geiler", "Geiler Hipia", plan_2 )
    var cliente_3 : UsuarioNormal = new UsuarioNormal( "guido@youp.org", "0123guido", "Guido Hernesto", plan_3 )

    var tipo_factura_1 : Factura = new Factura( cliente_1.getIdUsuario(), cliente_1.getNombre(), cliente_1.getPlan() )
    var tipo_factura_2 : Factura = new Factura( cliente_2.getIdUsuario(), cliente_2.getNombre(), cliente_2.getPlan() )
    var tipo_factura_3 : Factura = new Factura( cliente_3.getIdUsuario(), cliente_3.getNombre(), cliente_3.getPlan() )

    var administrador_1 : UsuarioAdmin = new UsuarioAdmin( "root@cloki.net", "master", "Harold less" )
    var administrador_2 : UsuarioAdmin = new UsuarioAdmin( "master@eternet.net", "master", "Leo valderrama" )
    var administrador_3 : UsuarioAdmin = new UsuarioAdmin( "gerente@motzk.net", "master", "Murphi perla" )


    var pelicula_1 : Pelicula = new Pelicula( "Interestelar II", generos, 169, 9.400 )
    var pelicula_2 : Pelicula = new Pelicula( "Titanic", generos, 156, 5.677 )
    var pelicula_3 : Pelicula = new Pelicula( "Francotirador", generos, 178, 7.650 )

    var generos_1 : List[String] = List()
    var generos_2 : List[String] = List()
    var generos_2 : List[String] = List() 

    generos_1 = "CIENCIA FICCION" :: "DRAMA" :: "MISTERIO" :: "AVENTURAS" :: "EPICO" :: generos_1
    generos_2 = "ROMANTICO" :: "CATASTROFE" :: "DRAMA" :: "EPICO" :: "HISTORICO" :: generos_2
    generos_3 = "BELICO" :: "DRAMA" :: "HISTORICO" :: "ACCION" :: "AVENTURA" :: generos_3
      
}