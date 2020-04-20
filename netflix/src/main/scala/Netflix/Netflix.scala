package Netflix

import Usuario.Usuario
import Usuario.UsuarioNormal
 
class Netflix extends Usuario with UsuarioNormal {
    
    /*Atributos*/

    private var _peliculas : List[Pelicula] = List()
    private var _usuarios : List[Usuario] = List()
    private var _registros : List[Registro] = List()
    private var _planes : List[Planes] = List()

    /*Setters*/

    /*Métodos*/
    def registroUsuario(cuenta : String, contra : String) : Unit = {
        var usuarioTemp : Usuario = _
        usuarioTemp.nombre = cuenta
        usuarioTemp.contraseña = contra
        usuarios += usuarioTemp
    }
    def logeoUsuario(cuenta : String, contra : String) : Boolean = {
        var pos : Double = _ 
        var pos2 : Double = _ 
        for(n <- _usuarios) {
            if(n.nombre == cuenta) {
                pos2 = pos
            }
            pos = pos + 1
        }
        if(_usuarios(pos2)) {
            if(contra == _usuarios(pos2).contraseña) {
                return true
            }
        }
        return false
    }
    def buscarPelicula(nombre : String) : Boolean = {
        for(n <- _peliculas) {
            if(nombre == n) {
                return true
            }
        }
        return false
    }
}