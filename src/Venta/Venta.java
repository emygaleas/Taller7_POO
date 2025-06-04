package Venta;
import java.time.LocalDateTime;

public class Venta {
    String producto;
    int cantidad;
    double total;
    String cajero;
    LocalDateTime fecha;

    public Venta(String producto, int cantidad, double total, String cajero) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.total = total;
        this.cajero = cajero;
        this.fecha = LocalDateTime.now();
    }

    public void mostrar() {
        System.out.println(producto + " | Cantidad: " + cantidad + " | Total: $" + total + " | Cajero: " + cajero + " | Fecha: " + fecha);
    }
}
