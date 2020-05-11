package Servicios

trait ServiciosAdmin {
    // Métodos
    def modTimeOnLuz() : Unit
    def modTimeOffLuz() : Unit
    def modTimeOpenSalon() : Unit
    def modTimeOnTemperatura() : Unit
    def modTimeOffTemperatura() : Unit
    def modHorarioReserva1() : Unit
    def modHorarioReserva2() : Unit
    def habilitarSalon() : Unit
    def deshabilitarSalon() : Unit
}