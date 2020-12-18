
public class Pollo {
    private String pieza;
    private int minutos = 4;

    public Pollo() {
    }

    public Pollo(String pieza) {
        setPieza(pieza);
    }

    public String getPieza() {
        return pieza;
    }

    public void setPieza(String pieza) {
        if (pieza.equals("Pechuga") || pieza.equals("Muslo") || pieza.equals("Pierna") || pieza.equals("Ala")) {
            this.pieza = pieza;
        }
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @Override
    public String toString() {
        return pieza + ", " + minutos + " minutos";
    }
    
}
