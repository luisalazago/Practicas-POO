import org.scalatest.FunSuite
import org.scalatest.BeforeAndAfter

import Complemento._
import Usuarios._
import Netfliix._
import Planes._

class TipoFacturaTest extends FunSuite with BeforeAndAfter {
    
    var plan : Plan = new Plan("PREMIUN")

    var cliente : UsuarioNormal = new UsuarioNormal("harold@comp.org", "#7j3u12pd&%", "Harold Mauricio Hipia", plan)
    
    var tipo_factura : Factura = new Factura( cliente.getIdUsuario(), cliente.getNombre(), cliente.getPlan() )


    test("Al generar una factura se asigna un fecha de expedicion automaticamente.") {
        
        assert (tipo_factura.getFechaExpedicion() != "")
    }

    test("Al generar una factura se asigna un fecha de vencimiento automaticamente.") {
        
        assert (tipo_factura.getFechaVencimiento() != "")
    }

    test("Al generar una factura se asigna un ID automaticamente") {

        assert (tipo_factura.getIdFactura() > 0)
    }

    test("Al generar una factura su estado (cancelada, no cancelada) siempre es false (no calcelada).") {

        assert (tipo_factura.getCancelada() != true)
    } 

    test("Al generar un nuevo costo, el costo adicional; (anterior) de la factura debe ser menor al nuevo costo adicional.") {

        var ant_cobro_adicional : Double =  tipo_factura.getCobroAdicional()

        tipo_factura.agregarCostoAdicional(7.800)        
        assert (tipo_factura.getCobroAdicional() > ant_cobro_adicional)

    } 

    test("Al cobrar una factura, el dinero del cliente se le debe restar n cantidad (donde n es el valor total de la factura).") {

        var total_factura : Double = tipo_factura.getTotal()
        var saldo : Double = cliente.getSaldo()

        cliente.cobroPlan(total_factura)

        assert (cliente.getSaldo() == saldo  - total_factura )
        

    }

    test("Al pagar una factura su estado debe ser: cancelada (true).") {

        tipo_factura.setCancelada(true)
        assert (tipo_factura.getCancelada() == true)
    }
}