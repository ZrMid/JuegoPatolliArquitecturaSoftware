
package datosPartida;

public class Jugador {
    private String rango;
    private String nombre;
    private String color;

    public Jugador(String rango, String nombre, String color) {
        this.rango = rango;
        this.nombre = nombre;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getRango() {
        return rango;
    }

    public String getNombre() {
        return nombre;
    }
    
}
