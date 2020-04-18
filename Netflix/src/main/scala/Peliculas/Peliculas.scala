package Peliculas

class Pelicula{
    /*Atributos*/
    private var _nombre : String
    private var _generos : List[String]
    private var _duracion : Double
    private var _precio : Double

    /*Constructores*/
    Pelicula(){
        _nombre = ""
        _duracion = 0
        _precio = 0
    }

    Pelicula(nuevoNombre : String, nuevaDuracion : Double, nuevoPrecio : Double){
        _nombre = nuevoNombre
        _duracion = nuevaDuracion
        _precio = nuevoPrecio
    }

    /*Getters*/
    def nombre = _nombre
    def generos = _generos
    def duracion = _duracion
    def precio = _precio

    /*Setters*/

    def nombre_= (nuevoNombre : String){
        if(_nombre == ""){
            _nombre = nuevoNombre
        }
    }

    def duracion_= (nuevaDuracion : Double){
        if(_duracion == 0){
            _duracion = nuevaDuracion
        }
    }

    def precio_= (nuevoPrecio : Double) = _precio = nuevoPrecio

    /*Metodos*/
    def agregarGeneros(nuevoGenero : String){
        var ver : Bool = true // Variable para poder saber si el genero ya esta en la lista de generos
        var temp : String = // Variable que me guarda el valor que hay en la lista
        while(ver){
            _generos.foreach(temp = _)
            if(temp == nuevoGenero){
                ver = false
            } // Me dice que halló el genero
        }

        if(ver){
            nuevoGenero :: _generos
        } 
    }
}
