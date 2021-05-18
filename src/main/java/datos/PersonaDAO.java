/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import static datos.Conexion.*;
import domain.Persona;
import java.sql.*;
import java.util.*;



public class PersonaDAO {

    private static final String SQL_SELECT = "SELECT id_persona,nombre,apellido,email,telefono FROM  test.persona";
    private static final String SQL_INSERT = "INSERT INTO test.persona(nombre,apellido,email,telefono) VALUES(?,?,?,?)";
    private static final String SQL_UPDATE = "UPDATE test.persona SET nombre = ?,apellido = ?, email = ? , telefono = ? WHERE id_persona = ?";
    private static final String SQL_DELETE = "DELETE FROM test.persona WHERE id_persona = ?";

    public List<Persona> seleccionar() {
        Connection conx = null;
        PreparedStatement stt = null;
        ResultSet rs = null;
        Persona persona;
        List<Persona> personas = new ArrayList<>();

        try {
            conx = getConexion();
            stt = conx.prepareStatement(SQL_SELECT);
            rs = stt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                persona = new Persona(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                close(rs);
                close(stt);
                close(conx);

            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return personas;
    }

    public int insertar(Persona persona) {
        Connection con = null;
        PreparedStatement stt = null;
        int registro = 0;

        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_INSERT);
            stt.setString(1, persona.getNombre());
            stt.setString(2, persona.getApellido());
            stt.setString(3, persona.getEmail());
            stt.setString(4, persona.getTelefono());
            registro = stt.executeUpdate();//este metodo se usa cuando se actulizan datos o se modifica algo en la base de datos, puede ejecutar sentencias update,delete o insert.
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally{
            
            try {
                close(stt);
                close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registro;
    }
    
    public int actulizar(Persona persona){
        int registro=0;
        Connection con = null;
        PreparedStatement stt = null;
        
        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_UPDATE);            
            stt.setString(1, persona.getNombre());
            stt.setString(2, persona.getApellido());
            stt.setString(3, persona.getEmail());
            stt.setString(4, persona.getTelefono());
            stt.setInt(5, persona.getIdPersona());
            registro = stt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return registro;
    }
    
    public int eliminar(Persona persona){
        int registro = 0;
        Connection con = null;
        PreparedStatement stt = null;
        
        try {
            con = getConexion();
            stt = con.prepareStatement(SQL_DELETE);
            stt.setInt(1, persona.getIdPersona());
            registro = stt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        return registro;
    }
}
