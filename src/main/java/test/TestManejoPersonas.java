/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

/**
 *
 * @author Acmm
 */
public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();
        
        
        
//        Persona persona1 = new Persona("arnold", "perez", "mer@hotmail.com", "3152045");       
//        personaDao.insertar(persona1);        
//        //Persona personaActulizar = new Persona(7,"stevin","gonzales","hola@gmail.com","375552");
//        //Persona personaEliminar = new Persona(8);
//        //personaDao.eliminar(personaEliminar);
//        //personaDao.actulizar(personaActulizar);
        
        
        List<Persona> personas = personaDao.seleccionar();

        personas.forEach(persona -> {
            System.out.println(persona);
        });

    }
}
