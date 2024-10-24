public class Test 
{
	public static void main(String[] args) {
        Gestor gestor = new Gestor();

        // Crear y agregar personajes
        gestor.agregarPersonaje(new Personaje("Caballero", 4, 2, 4, 2));
        gestor.agregarPersonaje(new Personaje("Guerrero", 2, 4, 2, 4));
        gestor.agregarPersonaje(new Personaje("Arquero", 2, 4, 1, 8));

        // Mostrar personajes
        System.out.println("Personajes actuales:");
        gestor.mostrarPersonajes();

        // Modificar un personaje
        System.out.println("\nModificando el personaje 'Arquero'...");
        gestor.modificarPersonaje("Arquero", 3, 5, 1, 9);

        // Mostrar personajes después de la modificación
        System.out.println("\nPersonajes después de la modificación:");
        gestor.mostrarPersonajes();

        // Eliminar un personaje
        System.out.println("\nEliminando el personaje 'Guerrero'...");
        gestor.eliminarPersonaje("Guerrero");

        // Mostrar personajes después de la eliminación
        System.out.println("\nPersonajes después de la eliminación:");
        gestor.mostrarPersonajes();
    }
}
