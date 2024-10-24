// Clase ArrayPersona para almacenar una lista de personas
public class ArrayPersona {
    // Atributos de la clase
    public Persona[] arreglo; // Arreglo para almacenar objetos de tipo Persona
    final int max = 128; // Tamaño máximo del arreglo
    int tamano = 0; // Tamaño actual del arreglo

    // Constructor de la clase
    public ArrayPersona() {
        this.arreglo = new Persona[this.max]; // Inicializa el arreglo con el tamaño máximo
    }

    // Método para imprimir una persona por su nombre
    public void printArray(String nombre) {
        boolean encontrado = false;
        for (int i = 0; i < this.tamano; i++) { // Recorre el arreglo hasta el tamaño actual
            if (this.arreglo[i].getNombre().equalsIgnoreCase(nombre)) { // Si el nombre coincide, ignorar mayúsculas
                System.out.println(this.arreglo[i]); // Imprime la persona
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Persona no encontrada.");
        }
    }

    // Método para agregar una persona al arreglo
    public void addArray(Persona persona) {
        if (this.tamano == max) { // Si el arreglo está lleno
            System.out.println("Error: No se pueden agregar más personas. El arreglo está lleno.");
            return;  // En lugar de salir, solo devuelve un mensaje de error
        }
        this.arreglo[this.tamano++] = persona; // Agrega la persona al arreglo y aumenta el tamaño
    }
}