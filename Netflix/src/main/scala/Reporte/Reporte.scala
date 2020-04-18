package Reporte

class Reporte{

    /*Atributos*/
    var _nombre : String
    var _visto : Double = 0

    /*Constructores*/
    Reporte(){
        _nombre = ""
    }

    Reporte(nuevoNombre : String){
        _nombre = nuevoNombre
    }

    /*Getters*/
    def nombre = _nombre
    def visto = _visto

    /*Setters*/
    def nombre_= (nuevoNombre : String){
        if(_nombre == ""){ 
            _nombre = nuevoNombre
        }
    }

    /*Metodos*/
    def aumentar(){
        _visto += 1
    }
}