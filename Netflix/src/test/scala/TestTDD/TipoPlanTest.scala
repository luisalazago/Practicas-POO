import org.scalatest.FunSuite

import Planes.Plan


class TipoPlanTest extends FunSuite {


   

    test ("Al crear un plan premiun, el usuario puede ver peliculas sin HD") {

        var tipo_plan : Plan = new Plan("PREMIUN")
        assert (tipo_plan.getPeliculaSinHD() == true)
    }
 
    test ("Al crear un plan premiun, el usuario puede ver peliculas en HD") {

        var tipo_plan : Plan = new Plan("PREMIUN")
        assert (tipo_plan.getPeliculaEnHD() == true)
    }
    
    test ("Al crear un plan premiun, el usuario puede ver peliculas en ULTRA HD") {

        var tipo_plan : Plan = new Plan("PREMIUN")
        assert (tipo_plan.getPeliculaEnUltraHD() == true)
    } 

        test ("Al crear un plan estadar, el usuario puede ver peliculas sin HD") {

        var tipo_plan : Plan = new Plan("ESTANDAR")
        assert (tipo_plan.getPeliculaSinHD() == true)
    }
 
    test ("Al crear un plan estandar, el usuario puede ver peliculas en HD") {

        var tipo_plan : Plan = new Plan("ESTANDAR")
        assert (tipo_plan.getPeliculaEnHD() == true)
    }
    
    test ("Al crear un plan estandar, el usuario NO puede ver peliculas en ULTRA HD") {

        var tipo_plan : Plan = new Plan("ESTANDAR")
        assert (tipo_plan.getPeliculaEnUltraHD() == false)
    } 

    test ("Al crear un plan basico, el usuario puede ver peliculas sin HD") {

        var tipo_plan : Plan = new Plan("BASICO")
        assert (tipo_plan.getPeliculaSinHD() == true)
    }
 
    test ("Al crear un plan basico, el usuario NO puede ver peliculas en HD") {

        var tipo_plan : Plan = new Plan("BASICO")
        assert (tipo_plan.getPeliculaEnHD() == false)
    }
    
    test ("Al crear un plan basico, el usuario NO puede ver peliculas en ULTRA HD") {

        var tipo_plan : Plan = new Plan("BASICO")
        assert (tipo_plan.getPeliculaEnUltraHD() == false)
    } 

}