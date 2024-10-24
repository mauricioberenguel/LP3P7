import java.io.Serializable;

public class Personaje implements Serializable { 
	// Implementamos Serializable para 
	//permitir guardarlo en un archivo binario
    private String nombre;
    private int vida;
    private int ataque;
    private int defensa;
    private int alcance;

    // Constructor para crear un personaje
    public Personaje(String nombre, int vida, int ataque, int defensa, int alcance) {
        this.nombre = nombre;
        setVida(vida);
        setAtaque(ataque);
        setDefensa(defensa);
        setAlcance(alcance);
    }

    // Getters y Setters para los atributos, 
    //asegurando que los valores sean mayores que cero
    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        if (vida > 0) {
            this.vida = vida;
        } else {
            throw new IllegalArgumentException("La vida debe ser mayor que cero");
        }
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        if (ataque > 0) {
            this.ataque = ataque;
        } else {
            throw new IllegalArgumentException("El ataque debe ser mayor que cero");
        }
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        if (defensa > 0) {
            this.defensa = defensa;
        } else {
            throw new IllegalArgumentException("La defensa debe ser mayor que cero");
        }
    }

    public int getAlcance() {
        return alcance;
    }

    public void setAlcance(int alcance) {
        if (alcance > 0) {
            this.alcance = alcance;
        } else {
            throw new IllegalArgumentException("El alcance debe ser mayor que cero");
        }
    }

    @Override
    public String toString() {
        return "Personaje: " + nombre + " [Vida=" + vida + ", Ataque=" + ataque + ", Defensa=" + defensa + ", Alcance=" + alcance + "]";
    }
}