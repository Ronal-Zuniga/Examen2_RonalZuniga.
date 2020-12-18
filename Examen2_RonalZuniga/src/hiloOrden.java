
import java.util.ArrayList;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class hiloOrden extends Thread {

    private JProgressBar barra;
    private Orden orden;
    private JTable tabla;
    private boolean vive;
    private boolean flag;

    public hiloOrden(JProgressBar barra, Orden orden, JTable tabla) {
        this.barra = barra;
        this.orden = orden;
        this.tabla = tabla;
        vive = true;
    }

    public JProgressBar getBarra() {
        return barra;
    }

    public void setBarra(JProgressBar barra) {
        this.barra = barra;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public boolean isVive() {
        return vive;
    }

    public void setVive(boolean vive) {
        this.vive = vive;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public void run() {
        ArrayList<Pollo> pollo = orden.getPiezas();
        ArrayList<Complemento> com = orden.getComplementos();
        DefaultTableModel m = (DefaultTableModel)tabla.getModel();
        if (!pollo.isEmpty()) {
            setFlag(true);
        } else {
            setFlag(false);
        }
        while (vive) {
            if (flag) {
                for (int j = 0; j < pollo.size(); j++) {
                    barra.setValue(0);
                    barra.setMaximum(pollo.get(j).getMinutos());
                    for (int i = 0; i <= barra.getMaximum(); i++) {
                        barra.setValue(i);
                    }
                    Object[] row = {
                        orden.getNum_orden(), pollo.get(j).getPieza(), pollo.get(j).getMinutos()
                    }; 
                    m.addRow(row);
                    tabla.setModel(m);
                    if (j == pollo.size() - 1) {
                        setFlag(false);
                    }
                }
            } else {
                for (int i = 0; i < com.size(); i++) {
                    barra.setValue(0);
                    barra.setMaximum(com.get(i).getMinutos());
                    for (int j = 0; j <= barra.getMaximum(); j++) {
                        barra.setValue(j);
                    }
                    Object[] row = {
                        orden.getNum_orden(), com.get(i).getTipo(), com.get(i).getMinutos()
                    }; 
                    m.addRow(row);
                    tabla.setModel(m);
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
            }
        }
    }

}
