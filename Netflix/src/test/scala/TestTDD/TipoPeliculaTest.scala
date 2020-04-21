import org.scalatest.FunSuite
import Complemento.Pelicula


class TipoPeliculaTest extends FunSuite {
    
    var generos : List[String] = List() 

    generos = "CIENCIA FICCION" :: "DRAMA" :: "MISTERIO" :: "AVENTURAS" :: "EPICO" :: generos

    var tipo_pelicula : Pelicula = new Pelicula("Interestelar II", generos, 169, 3.400)


    test ("Una pelicula debe tener un nombre especifico") {

        assert (tipo_pelicula.getNombre() != "")
    }

    test ("Una pelicula debe tener al menos un genero. ") {

        assert (tipo_pelicula.getGeneros().isEmpty == false)
    }

    test("Al crear una pelicula las descargas son siempre 0.") {
        
        assert (tipo_pelicula.getDescargas() == 0)
    }

    test("Al crear una pelicula las vistas son siempre 0.") {
        
        assert (tipo_pelicula.getVistas() == 0)
    }


}