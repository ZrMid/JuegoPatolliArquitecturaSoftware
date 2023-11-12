package datosPartida;

public class Ficha {

    private String noFicha;
    private String cordX;
    private String cordY;

    public Ficha(String noFicha) {
        this.noFicha = noFicha;
        this.cordX = "";
        this.cordY = "";
    }

    public String getNoFicha() {
        return noFicha;
    }

    public void setNoFicha(String noFicha) {
        this.noFicha = noFicha;
    }

    public String getCordX() {
        return cordX;
    }

    public void setCordX(String cordX) {
        this.cordX = cordX;
    }

    public String getCordY() {
        return cordY;
    }

    public void setCordY(String cordY) {
        this.cordY = cordY;
    }
    
    
}
