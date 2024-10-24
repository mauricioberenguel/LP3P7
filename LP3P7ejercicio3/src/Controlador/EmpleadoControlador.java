package Controlador;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import Modelo.Empleado;
import Vista.EmpleadoVista;

public class EmpleadoControlador {
    private static final String ARCHIVO_EMPLEADOS = "empleados.dat";
    private List<Empleado> empleados;
    private EmpleadoVista vista;

    // Constructor
    public EmpleadoControlador(EmpleadoVista vista) {
        this.vista = vista;
        empleados = leerEmpleados();
    }

    // Leer los empleados desde un archivo binario
    public List<Empleado> leerEmpleados() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_EMPLEADOS))) {
            return (List<Empleado>) ois.readObject();
        } catch (FileNotFoundException e) {
            vista.mostrarMensaje("Archivo no encontrado. Creando un nuevo archivo...");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException e) {
            vista.mostrarMensaje("Error al leer el archivo: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    // Guardar los empleados en el archivo binario
    public void guardarEmpleados() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_EMPLEADOS))) {
            oos.writeObject(empleados);
        } catch (IOException e) {
            vista.mostrarMensaje("Error al guardar el archivo: " + e.getMessage());
        }
    }

    // Listar todos los empleados
    public void listarEmpleados() {
        if (empleados.isEmpty()) {
            vista.mostrarMensaje("No hay empleados registrados.");
        } else {
            for (Empleado empleado : empleados) {
                vista.mostrarEmpleado(empleado);
            }
        }
    }

    // Agregar un nuevo empleado
    public void agregarEmpleado() {
        Empleado nuevoEmpleado = vista.ingresarEmpleado();
        for (Empleado e : empleados) {
            if (e.getNumero() == nuevoEmpleado.getNumero()) {
                vista.mostrarMensaje("El empleado con el número " + nuevoEmpleado.getNumero() + " ya existe.");
                return;
            }
        }
        empleados.add(nuevoEmpleado);
        guardarEmpleados();
        vista.mostrarMensaje("Empleado agregado exitosamente.");
    }

    // Buscar un empleado por su número
    public void buscarEmpleado() {
        int numero = vista.solicitarNumeroEmpleado();
        for (Empleado e : empleados) {
            if (e.getNumero() == numero) {
                vista.mostrarEmpleado(e);
                return;
            }
        }
        vista.mostrarMensaje("Empleado no encontrado.");
    }

    // Eliminar un empleado por su número
    public void eliminarEmpleado() {
        int numero = vista.solicitarNumeroEmpleado();
        Empleado empleadoAEliminar = null;
        for (Empleado e : empleados) {
            if (e.getNumero() == numero) {
                empleadoAEliminar = e;
                break;
            }
        }
        if (empleadoAEliminar != null) {
            empleados.remove(empleadoAEliminar);
            guardarEmpleados();
            vista.mostrarMensaje("Empleado eliminado exitosamente.");
        } else {
            vista.mostrarMensaje("Empleado no encontrado.");
        }
    }

    // Ejecutar la aplicación
    public void ejecutar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1:
                    listarEmpleados();
                    break;
                case 2:
                    agregarEmpleado();
                    break;
                case 3:
                    buscarEmpleado();
                    break;
                case 4:
                    eliminarEmpleado();
                    break;
                case 5:
                    vista.mostrarMensaje("Saliendo del programa...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 5);
    }
}