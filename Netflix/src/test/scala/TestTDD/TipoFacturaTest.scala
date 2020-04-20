import org.scalatest.FunSuite
import Complemento.Factura

class TipoFacturaTest extends FunSuite {

    var tipo_factura : Factura = new Factura

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
}