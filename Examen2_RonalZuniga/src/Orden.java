
import java.util.ArrayList;


public class Orden {
    private int num_orden;
    private ArrayList<Pollo> piezas = new ArrayList();
    private ArrayList<Complemento> complementos = new ArrayList();

    public Orden() {
    }

    public Orden(int num_orden) {
        this.num_orden = num_orden;
    }

    public int getNum_orden() {
        return num_orden;
    }

    public void setNum_orden(int num_orden) {
        this.num_orden = num_orden;
    }

    public ArrayList<Pollo> getPiezas() {
        return piezas;
    }

    public void setPiezas(ArrayList<Pollo> piezas) {
        this.piezas = piezas;
    }

    public ArrayList<Complemento> getComplementos() {
        return complementos;
    }

    public void setComplementos(ArrayList<Complemento> complementos) {
        this.complementos = complementos;
    }

    @Override
    public String toString() {
        return num_orden + ", " + piezas + ", " + complementos;
    }
    
}
