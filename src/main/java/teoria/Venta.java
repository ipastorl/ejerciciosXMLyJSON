package teoria;

import java.util.Date;

public class Venta {
    private Date fecha;
    private String cliente;

    public Venta(Date fecha, String cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "fecha=" + fecha +
                ", cliente='" + cliente + '\'' +
                '}';
    }
}
