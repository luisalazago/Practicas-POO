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

    /*before {


//        tipo_factura.set
        
    }*/
    

  /*  test("Al generar una factura se asigna un fecha de expedicion automaticamente.") {
        
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
    }*/
/*
    test("Al generar un nuevo costo, el costo adicional; (anterior) de la factura debe ser menor al nuevo costo adicional.") {


        assert (tipo_factura.getCobroAdicional()> ant_subtotal)

    }  */ 

    

    /*test("Al pagar una factura su estado debe ser: cancelada (true).") {

       // tipo_factura.setCancelada(true)
        //assert (tipo_factura.getCancelada() == true)
    }*/
}