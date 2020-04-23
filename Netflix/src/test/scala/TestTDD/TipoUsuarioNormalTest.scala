import org.scalatest.FunSuite

import Usuarios.UsuarioNormal
import Planes.Plan
import Complemento.Factura
import util.control.Breaks._

class TipoUsuarioNormalTest extends FunSuite {

    var plan : Plan = new Plan("BASICO")

    var tipo_usuario_normal : UsuarioNormal = new UsuarioNormal("geiler@gmail.org", "#7j3rtpd&%", "Geiler Hipia Mejia", plan)
    
    var factura : Factura = new Factura( tipo_usuario_normal.getIdUsuario(), tipo_usuario_normal.getNombre(), tipo_usuario_normal.getPlan() )

    test("Cuando se crea un usuario normal, debe tener un nombre") {

        assert (tipo_usuario_normal.getNombre() != "")
    }

    test("Cuando se crea un usuario normal, debe tener un correo") {

        assert (tipo_usuario_normal.getCorreo() != "")
    }

    test("Cuando se crea un usuario normal, debe tener una contrasena ") {

        assert (tipo_usuario_normal.getContrasena() != "")
    }
    
    test("Cuando se crea un usuario normal, se le asigna un ID automaticamente") {

        assert (tipo_usuario_normal.getIdUsuario() != "")
    }

    test("Si el usuario tiene un plan, entonces tiene una factura.") (pending) 

    test("Si el usuario tiene dinero entonces puede comprar un plan.") (pending) 
}
