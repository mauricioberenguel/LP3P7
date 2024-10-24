package Vista;

import java.util.Scanner;
import Modelo.Empleado;

public class EmpleadoVista {
    private Scanner scanner;

    public EmpleadoVista() {
        scanner = new Scanner(System.in);
    }

    // Menú principal
    public int mostrarMenu() {
        System.out.println("\n--- Menú de Gestión de Empleados ---");
        System.out.println("1. Listar todos los empleados");
        System.out.println("2. Agregar un nuevo empleado");
        System.out.println("3. Buscar empleado por número");
        System.out.println("4. Eliminar empleado por número");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextInt();
    }

    // Pedir datos para crear un nuevo empleado
    public Empleado ingresarEmpleado() {
        System.out.print("Ingrese el número del empleado: ");
        int numero = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Ingrese el nombre del empleado: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el sueldo del empleado: ");
        double sueldo = scanner.nextDouble();
        return new Empleado(numero, nombre, sueldo);
    }

    // Solicitar el número del empleado para buscar o eliminar
    public int solicitarNumeroEmpleado() {
        System.out.print("Ingrese el número del empleado: ");
        return scanner.nextInt();
    }

    // Mostrar un mensaje al usuario
    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    // Mostrar un empleado
    public void mostrarEmpleado(Empleado empleado) {
        if (empleado != null) {
            System.out.println(empleado);
        } else {
            System.out.println("Empleado no encontrado.");
        }
    }
}
