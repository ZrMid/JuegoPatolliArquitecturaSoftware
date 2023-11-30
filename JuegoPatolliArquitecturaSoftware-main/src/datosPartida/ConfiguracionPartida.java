package datosPartida;

public class ConfiguracionPartida {
    private int noJugadores;
    private int noCasillasAspa;
    private int noFichas;
    private int noFrijoles;

    public ConfiguracionPartida(int noJugadores, int noCasillasAspa, int noFichas, int noFrijoles) {
        this.noJugadores = noJugadores;
        this.noCasillasAspa = noCasillasAspa;
        this.noFichas = noFichas;
        this.noFrijoles = noFrijoles;
    }

    public int getNoFrijoles() {
        return noFrijoles;
    }

    public int getNoJugadores() {
        return noJugadores;
    }

    public int getNoCasillasAspa() {
        return noCasillasAspa;
    }

    public int getNoFichas() {
        return noFichas;
    }
    
}
