package datosPartida;

public class Ficha {

    private String noFicha;
    private int cordX;
    private int cordY;

    public Ficha(String noFicha, int x, int y) {
        this.noFicha = noFicha;
        this.cordX = x;
        this.cordY = y;
    }

    public String getNoFicha() {
        return noFicha;
    }

    public void setNoFicha(String noFicha) {
        this.noFicha = noFicha;
    }

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }
    
    
}
