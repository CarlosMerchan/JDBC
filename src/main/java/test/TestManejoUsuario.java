/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.UsuarioDAO;
import domain.Usuario;
import java.util.List;


public class TestManejoUsuario {
    
    public static void main(String[] args) {
        UsuarioDAO usuarioDao = new UsuarioDAO();
        
//        Usuario usuario1 = new Usuario("rey","Sombra");
//        usuarioDao.insertar(usuario1);
//        Usuario usuarioActulizar = new Usuario(2,"Carlos","123");
//        usuarioDao.actulizar(usuarioActulizar);
//        Usuario usuarioEliminar = new Usuario(4);
//        usuarioDao.eliminar(usuarioEliminar);
//        
        
        List<Usuario> usuarios  = usuarioDao.seleccionar();
        usuarios.forEach(usuario ->{
            System.out.println(usuario);}
        );
    }
}
