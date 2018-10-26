package ec.edu.ister.controlador;

import ec.edu.ister.vista.FrmDocente;
import ec.edu.ister.vista.FrmEstudiante;
import ec.edu.ister.vista.FrmLogin;

/**
 *
 * @author JHON
 */
public class Coordinador {
    FrmLogin login = new FrmLogin(this);
    FrmDocente docente = new FrmDocente(this);
    FrmEstudiante estudiante = new FrmEstudiante(this);
    
        public void mostrarLogin(){
            login.setVisible(true);
            docente.setVisible(false);
            estudiante.setVisible(false);
        }
        public void mostrarDocente(){
            docente.setVisible(true);
            login.setVisible(false);
        }
        public void mostrarEstudiante(){
            estudiante.setVisible(true);
            login.setVisible(false);
        }
        public boolean validarCedula(String parametro) {
            boolean respuestaValidacion = false;
            try {
                if (parametro.length() == 10) {
                    int tercerDigito = Integer.parseInt(parametro.substring(2, 3));

                    if (tercerDigito < 6) {
                        int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                        int verificador = Integer.parseInt(parametro.substring(9,10));
                        int suma = 0;
                        int digito = 0;

                            for (int i = 0; i < (parametro.length() - 1); i++) {
                             digito = Integer.parseInt(parametro.substring(i, i + 1))* coefValCedula[i];
                             suma += ((digito % 10) + (digito / 10));
                            }

                        if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                            respuestaValidacion = true;
                        }else if ((10 - (suma % 10)) == verificador) {
                            respuestaValidacion = true;
                        } else {
                            respuestaValidacion = false;
                        }
                    } else {
                        System.out.println("La cédula ingresada no existe en ecuador ");
                        respuestaValidacion = false;
                    }
                } else {
                    System.out.println("La cédula ingresada no tine 10 digitos ");
                    respuestaValidacion = false;
                }
            } catch (NumberFormatException numFormatEx) {
                respuestaValidacion = false;
            } catch (Exception ex) {
                System.out.println("Una excepcion ocurrio en el proceso de validadcion ");
                respuestaValidacion = false;
            }
            if (!respuestaValidacion) {
                System.out.print("La cédula ingresada es Incorrecta ");
            }
            if (respuestaValidacion) {
                System.out.print("La cédula ingresada es Correcta ");
            }
        return respuestaValidacion;
    }
}
