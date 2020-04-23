import org.scalatest.GivenWhenThen
import org.scalatest.FeatureSpec
import Netfliix._
import Pelicula._
import Usuarios._
import Planes._

class NetflixTest extends FeatureSpec with GivenWhenThen {

    var netflix : Netflix = new Netflix
    var generos : List[String] = List()
    generos = "acción"::generos
    var plan1 : Plan = new Plan
    var pelicula3 : Pelicula = new Pelicula("Taken", generos, 120.3, 100, 8, 5)
    var peliculas2 : List[Pelicula] = List()
    peliculas2 = pelicula3::peliculas2

    feature("Crear Pelicula") {
        scenario("Pelicula de cualquier genero") {
            Given("Dada una película")
            var pelicula : Pelicula = new Pelicula("Taken", generos, 120.3, 100, 8, 5)
            
            When("Cundo se crea una película en netflix")
            netflix.agregarPelicula(pelicula)

            Then("Las películas disponibles no están vacías")
            var peliculas : List[Pelicula] = netflix.getPeliculas()
            assert(peliculas.length > 0)
        }
    }

    feature("Buscar Pelicula") {
        scenario("Película de acción") {
            Given("Dada una película de acción")
            var pelicula2 : Pelicula = new Pelicula("Taken", generos, 120.3, 100, 8, 5)

            When("Cuando se busca una película de acción en netflix")
            netflix.agregarPelicula(pelicula2)
            var comprobar : Pelicula = netflix.buscarPelicula("Taken")

            Then("Se econtró la película solicitada de acción")
            assert(comprobar != null)
        }
    }

    freature("Crear Usuario") {
        scenario("Usuario Normal") {
            Given("Dado un usuario normal")
            var usuario : UsuarioNormal = new UsuarioNormal(false, plan1, false, 128.250, peliculas2)

            When("Cuando el usuario cree una cuenta")
            netflix.registroUsuario(usuario)

            Then("El usuario va a ser un Uusuario Normal")
            var usuariosN : List[UsuarioNormal] = netflix.getUsuariosNormales()
            assert(usuariosN.length > 0)
        }
        scenario("Usuario Administrativo") {
            Given("Dado un usuario Administrativo")
            var ususario2 : UsuarioAdmin = new UsuarioAdmin

            When("Cuando el usuario se registre")
            netflix.registroUsuarioAdmin(ususario2)

            Then("El usuario va a ser un Usuario Administrativo")
            var usuariosA : List[UsuarioAdmin] = netflix.getUsuariosAdministradores()
            assert(usuariosA.length > 0)
        }
    }

    freature("Logear Usuario") {
        scenario("Usuario Normal") {
            Given("Dado un correo y una contraseña")
            var correo : String = "ejemplo_usuario@gmail.com"
            var cantra : String = "100100"

            When("Cuando el usuario haga un login en el sistema")
            var usuario : UsuarioNormal = netflix.logeoUsuario(correo, contra)

            Then("El usuario se habrá logeado exitosamente")
            assert(usuario != null)
        }
        scenario("Usuario Administrativo") {
            Given("Dado un correo y una contraseña")
            var correo : String = "ejemplo_usuario_admin@gmail.com"
            var contra : String = "001001"

            When("Cuando el usuario admin haga login en el sistema")
            var usuarioA : UsuarioAdmin = netflix.logeoAdmin(correo, contra)

            Then("El usuario administrativo se habrá exitosamente")
            assert(usuarioA != null)
        }
    }

    freature("Buscar Usuario") {
        scenario("Usuarios en general") {
            Given("Dado un Usuario Normal o Administrativo")
            var usuarioN : String = "EjemplosNormal"
            // var usuarioA : String = "EjemplosAdmin"

            When("Cuando se busque en el sistema el usuario")
            var comprobante : Boolean = netflix.buscarUsuario(usuarioN)
            // var comprobante2 : Boolean = netflix.buscarUsuario(usuarioA)

            Then("Se ha encontrado el usuario")
            assert(comprobante == true)
            // assert(comprobante2 == true)
        }
    }

    freature("Crear Factura") {
        scenario("Factura para un Usuario") {
            Given("Dados los datos de un Usuario")
            var id_usuario : String = _
            var nombre_usuario : String = "ejemplo"
            var nuevo_plan : Plan = new Plan

            When("Cuando se esté recibiendo lo datos para la factura")
            var factura : Factura = netflix.generarFactura(id_usuario, nombre_usuario, nuevo_plan)

            Then("La factura se le habrá generado al usuario")
            var facturas : List[Factura] = List()
            facturas = factura::facturas
            assert(facturas.lenght > 0)
        }
    }

    freature("Comprar Plan") {
        scenario("Planes para que un usuario los compre") {
            Given("Dado un usuario con el plan que desea")
            var id_usuario : String = _
            var plan1 : Plan = new Plan("plan1", "el plan más barato", 80.5, 2, true, false, false)

            When("Cuando el usuario esté comprando el plan")
            netflix.solicitudCompraPlan(id_usuario, plan1)

            Then("El usuario habrá comprado el Plan exitosamente")
            var factura : Factura = netflix.generarFactura(id_usuario, "ejemplo", plan1)
            var facturas : List[Factura] = List()
            facturas = factura::facturas
            assert(facturas > 0)
        }
    }
}