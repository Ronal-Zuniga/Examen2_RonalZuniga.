
import javax.swing.JOptionPane;


public class Complemento {
    private String tipo;
    private int minutos;

    public Complemento() {
    }

    public Complemento(String tipo) {
        setTipo(tipo);
        setMinutos();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equals("Biscuit") || tipo.equals("Puré") || tipo.equals("Papas") || tipo.equals("Refresco") || tipo.equals("Pie")) {
            this.tipo = tipo;
        }
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos() {
        switch(this.tipo){
            case "Biscuit":
                this.minutos = 1;
                break;
                
            case "Puré":
                this.minutos = 2;
                break;
                
            case "Papas":
                this.minutos = 3;
                break;
                
            case "Refresco":
                this.minutos = 1;
                break;
                
            case "Pie":
                this.minutos = 5;
                break;
                
            default: JOptionPane.showMessageDialog(null, "Tipo de complemento desconocido");
        }
    }

    @Override
    public String toString() {
        return tipo + ", " + minutos + " minutos";
    }
    
    
    
}
