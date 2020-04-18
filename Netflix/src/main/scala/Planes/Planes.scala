package Planes

class Plan{

    /*Atributos*/
    var _nombre : String
    var _descripcion : String
    var _precio : Double

    /*Constructores*/
    Plan(){
        _nombre = ""
        _descripcion = ""
        _precio = 0
    }

    Plan(nuevoNombre : String, nuevaDescripcion : String, nuevoPrecio : Double){
        _nombre = nuevoNombre
        _descripcion = nuevaDescripcion
        _precio = nuevoPrecio
    }

    /*Getters*/
    def nombre = _nombre
    def descripcion = _descripcion
    def precio = _precio

    /*Setters*/
    def nombre_= (nuevoNombre : String) = _nombre = nuevoNombre
    def descripcion_= (nuevaDescripcion : String) = _descripcion = nuevaDescripcion
    def precio_= (nuevoPrecio : Double) = _precio = nuevoPrecio
        
    }
}