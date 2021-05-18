
package test;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class TestMySqlJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/test?ussSll=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");en las ultimas versiones ya no es requerida, pero algunos servicios web la necesitan para funcionar
            Connection conexion = DriverManager.getConnection(url,"root","Root.859647*");//para generar la conexion , usuario y contraseña
            Statement instruccion = conexion.createStatement(); //clase  para ejecutar sentencias de sql
            var sql = "SELECT * FROM test.persona";
            ResultSet resultado = instruccion.executeQuery(sql);
            while(resultado.next()){//el next indicia que sigue un objeto a iterar hasta que acabe la tabla
                System.out.print(" Id_persona:"+resultado.getInt("id_persona"));
                System.out.print(" Nombre:"+resultado.getString("nombre"));
                System.out.print(" Apellido:"+resultado.getString("apellido"));
                System.out.print(" Email:"+resultado.getString("email"));
                System.out.print(" Telefono:"+resultado.getString("telefono"));
                System.out.println("");
            }
            resultado.close();
            instruccion.close();
            conexion.close();
        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            
        }
    }
    
}
