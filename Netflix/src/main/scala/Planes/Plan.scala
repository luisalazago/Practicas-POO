package Planes

class Plan {

    protected var _nombre : String = _
    protected var _descripcion : String = _
    protected var _precio : Double = _
    protected var _pantallas : Int = _
    protected var _cantidad_descargas : Int = _
    protected var _pelicula_sin_HD : Boolean = _
    protected var _pelicula_en_HD : Boolean = _
    protected var _pelicula_en_ULTRA_HD : Boolean = _
   


    def getNombre() : String = _nombre
    def getDescripcion() : String = _descripcion
    def getPrecio() : Double = _precio
    def getCantidadDescargas() : Int = _cantidad_descargas
    def getPeliculaSinHD() : Boolean = _pelicula_sin_HD
    def getPeliculaEnHD() : Boolean = _pelicula_en_HD
    def getPeliculaEnUltraHD() : Boolean = _pelicula_en_ULTRA_HD

    def conteoDescargas() {

       if (_cantidad_descargas > 0 ) {

           _cantidad_descargas = _cantidad_descargas  - 1
       }
    
    }

}