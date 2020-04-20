import org.scalatest.FunSuite
import Complemento.Pelicula


class TipoPeliculaTest extends FunSuite {
    
    var tipoPelicula : Pelicula = new Pelicula 

    test("Al crear una pelicula las descargas y sus vistas son siempre 0.") {
        
        println(tipoPelicula.getVistas())
        assert(tipoPelicula.getVistas() == 0 && tipoPelicula.getDescargas() == 0)

    }
}