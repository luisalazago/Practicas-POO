package Servicios

import java.util.Calendar

object HoraActual extends App {
    // Métodos
    def definirHoraActualMin() : Int = {
        val now = Calendar.getInstance()
        val minutos = now.get(Calendar.MINUTE)

        return minutos
    }
    def definirHoraActualHora() : Int = {
        val now = Calendar.getInstance()
        val hora= now.get(Calendar.HOUR_OF_DAY)

        return hora
    }
}