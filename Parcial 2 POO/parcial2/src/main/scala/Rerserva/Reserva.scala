package Reserva

class Reserva(hora1 : Int, hora2 : Int, materia : String) {
    // Atributos
    var _horario1 : Int = hora1
    var _horario2 : Int = hora2
    var _materiaActual : String = materia 

    // Getters
    def horario1 = _horario1
    def horario2 = _horario2
    def materiaActual = _materiaActual

    // Setters
    def horario1_=(nuevoHorario1 : Int) = _horario1 = nuevoHorario1
    def horario2_=(nuevoHorario2 : Int) = _horario2 = nuevoHorario2
    def materiaActual_=(nuevaMateria : String) = _materiaActual = nuevaMateria
}