package datos;

import static datos.Conexion.*;
import domain.Usuario;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {

    private static final String SQL_SELECT = "SELECT id_usuario,usuario,contrasena FROM test.usuario;";
    private static final String SQL_UPDATE = "UPDATE test.usuario SET usuario = ?,contrasena = ? WHERE id_usuario = ?;";
    private static final String SQL_DELETE = "DELETE FROM test.usuario WHERE id_usuario = ?;";
    private static final String SQL_INSERT = "INSERT INTO test.usuario (usuario,contrasena) VALUES (?,?);";

    public List<Usuario> seleccionar() {
        Connection con = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        Usuario usuario;
        List<Usuario> usuarios = new ArrayList<>();

        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_SELECT);
            rs = stt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String nombreUsuario = rs.getString("usuario");
                String contrasena = rs.getString("contrasena");
                usuario = new Usuario(idUsuario, nombreUsuario, contrasena);
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            try {
                close(rs);
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return usuarios;
    }

    public int eliminar(Usuario usuario) {
        Connection con = null;
        PreparedStatement stt = null;
        int registro = 0;
        
        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_DELETE);
            stt.setInt(1, usuario.getIdUsuario());
            registro = stt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {

            try {                
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }

    public int actulizar(Usuario usuario) {
        Connection con = null;
        PreparedStatement stt = null;
        int registro = 0;
        
        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_UPDATE);
            stt.setString(1, usuario.getUsuario());
            stt.setString(2, usuario.getContrasena());
            stt.setInt(3, usuario.getIdUsuario());
            registro = stt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {

            try {                
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
               
        return registro;
    }

    public int insertar(Usuario usuario) {
        Connection con = null;
        PreparedStatement stt  = null;
        int registro = 0;
        
        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_INSERT);
            stt.setString(1, usuario.getUsuario());
            stt.setString(2, usuario.getContrasena());
            registro = stt.executeUpdate();            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally {

            try {                
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
}
