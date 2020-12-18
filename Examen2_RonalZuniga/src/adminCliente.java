
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class adminCliente {

    private ArrayList<Cliente> clientes = new ArrayList();
    private File archivo = null;

    public adminCliente(String path) {
        archivo = new File(path);
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setCliente(Cliente c) {
        this.clientes.add(c);
    }

    public void cargarArchivo() {
        try {
            clientes = new ArrayList();
            Cliente temp;
            if (archivo.exists()) {
                try ( FileInputStream entrada = new FileInputStream(archivo);  ObjectInputStream objeto = new ObjectInputStream(entrada)) {
                    try {
                        while ((temp = (Cliente) objeto.readObject()) != null) {
                            clientes.add(temp);
                        }
                    } catch (EOFException e) {
                        e.printStackTrace();
                    }
                }
            } //fin if           
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void escribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(archivo);
            bw = new ObjectOutputStream(fw);
            for (Cliente t : clientes) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }
}
