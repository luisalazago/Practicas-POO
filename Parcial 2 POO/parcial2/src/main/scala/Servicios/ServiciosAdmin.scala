package Servicios

trait ServiciosAdmin {
    // Métodos
    def modTimeOnLuz(tiempo : Int) :  Int
    def modTimeOffLuz(tiempo : Int) : Int
    def modTimeOpenSalon(tiempo : Int) : Int
    def modTimeOnTemperatura(tiempo : Int) : Int
    def modTimeOffTemperatura(tiempo : Int) : Int
    def modHorarioReserva1(tiempo : Int) : Int
    def modHorarioReserva2(tiempo : Int) : Int
    def habilitarSalon(decision : Boolean) : Boolean
    def deshabilitarSalon(decision : Boolean) : Boolean
}