
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;


public class Cliente implements Serializable{
    private String nombre;
    private String apellido;
    private int id;
    private ArrayList<Orden> ordenes = new ArrayList();
    private File factura;
    private static final long SerialVersionUID=777L;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, int id) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(ArrayList<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public File getFactura() {
        return factura;
    }

    public void setFactura(File factura) {
        this.factura = factura;
    }

    @Override
    public String toString() {
        return nombre+"  "+apellido;
    }
    
}
