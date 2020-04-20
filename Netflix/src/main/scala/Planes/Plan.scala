package Planes

class Plan {

    protected var _nombre : String = _
    protected var _descripcion : String = _
    protected var _precio : Double = _
    protected var _pantallas : Int = _
    protected var _pelicula_sin_HD : Boolean = _
    protected var _pelicula_en_HD : Boolean = _
    protected var _pelicula_en_ULTRA_HD : Boolean = _
   

    def this(tipo_plan : String) {

        this()
        
        if (tipo_plan == "PREMIUN" ) {

            _nombre = "PREMIUN" 
            _precio = 48.230
            _descripcion = "Con contenido HD, UltraHD y hasta 4 reproducciones simultáneas y mas de 15 descargas disponibles."
            _pantallas = 4
            _pelicula_sin_HD = true
            _pelicula_en_HD = true
            _pelicula_en_ULTRA_HD = true

        }
        
        else if (tipo_plan == "ESTANDAR" ) {

            
            _nombre = "ESTANDAR"
            _precio = 34.750
            _descripcion = "Con contenido HD, UltraHD y hasta 4 reproducciones simultáneas y 5 descargar disponibles."
            _pantallas = 2
            _pelicula_sin_HD = true
            _pelicula_en_HD = true
            _pelicula_en_ULTRA_HD = false

        }

        else if (tipo_plan == "BASICO" ) {

            _nombre = "BASICO"
            _precio = 24.800
            _descripcion = "Sin contenido HD (ni UltraHD) y sólo una reproducción simultánea (en PC, TV, smartphone o tablet) y 0 descargas."
            _pantallas = 1
            _pelicula_sin_HD = true
            _pelicula_en_HD = false
            _pelicula_en_ULTRA_HD = false

        }


    }

    def getNombre() : String = _nombre
    def getDescripcion() : String = _descripcion
    def getPrecio() : Double = _precio
    def getPeliculaSinHD() : Boolean = _pelicula_sin_HD
    def getPeliculaEnHD() : Boolean = _pelicula_en_HD
    def getPeliculaEnUltraHD() : Boolean = _pelicula_en_ULTRA_HD


}