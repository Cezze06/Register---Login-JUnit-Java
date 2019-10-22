/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Entidad.Sistema;
import Entidad.Usuario;
import Frontera.FramePrincipal;
import static Frontera.FramePrincipal.sistema;
import java.util.ArrayList;


/**
 *
 * @author ZERAX
 */
public class ValidarRegistro {
    public ValidarRegistro(){
        
    }
    private Sistema sistema = FramePrincipal.sistema;
    
    public String verificarRegistro(Usuario usuario, String confirmarContrasenia){
        ArrayList <Usuario> usuarios = new ArrayList<Usuario>();
        if(!verificarLongitudNombre (usuario.getNombre()))
            return ("Longitud nombre incorrecta");
        if(!verificarLongitudPassword (usuario.getPassword()))
            return ("Longitud contraseña incorrecta");
        if(!verificarPasswordIguales (usuario.getPassword(), confirmarContrasenia))
            return ("Las contraseñas no coinciden");
        for (Usuario u: sistema.getUsuarios()){
            if(u.getNombre().equals(usuario.getNombre())){
                return ("El nombre ya existe");
            }
        }
        
        usuarios = sistema.getUsuarios();
        usuarios.add(usuario);
        sistema.setUsuarios(usuarios);
        
        return ("Usuario correctamente registrado.");
        
    }
    
    public boolean verificarLongitudNombre (String nombre){
            return (nombre.length() > 1 && nombre.length() < 7);
    }
    public boolean verificarLongitudPassword (String password){
            return (password.length() > 2 && password.length() < 7);
    }
    public boolean verificarPasswordIguales (String password, String password2){
        return (password.equals(password2));
    }
    
}
