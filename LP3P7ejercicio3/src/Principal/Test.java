package Principal;

import Controlador.EmpleadoControlador;
import Vista.EmpleadoVista;

public class Test 
{
	 public static void main(String[] args) 
	 {
	        EmpleadoVista vista = new EmpleadoVista();
	        EmpleadoControlador controlador = new EmpleadoControlador(vista);
	        controlador.ejecutar();
	  }
}