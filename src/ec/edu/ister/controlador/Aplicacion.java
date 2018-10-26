/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ister.controlador;

import ec.edu.ister.vista.FrmLogin;

/**
 *
 * @author JHON
 */
public class Aplicacion {
    public static void main(String[] args) {
        Coordinador coordinador = new Coordinador();
       // coordinador.mostrarLogin();
        coordinador.validarCedula("0605694256");
        
    }
}
