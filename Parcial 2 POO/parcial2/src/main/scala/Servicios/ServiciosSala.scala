package Servicios

trait ServiciosSala {
    // Métodos
    def encenderLuz(indice : Int, todos : Boolean) : Unit
    def apagarLuz(indice : Int, todos : Boolean) : Unit
    def encenderTemperatura(indice : Int, todos : Boolean) : Unit
    def apagarTemperatura(indice : Int, todos : Boolean) : Unit
    def reservar(hora1 : Int, hora2 : Int, materia : String, indice : Int) : Unit
    def accionPuerta(todos : Boolean, indice : Int, accion : Boolean) : Unit
}