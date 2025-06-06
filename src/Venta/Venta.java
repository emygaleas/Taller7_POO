package Venta;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter; // Import para formatear la fecha y hora

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaFormateada = fecha.format(formatter);
        System.out.println("Producto: " + producto + " | Cantidad: " + cantidad + " | Total: $" + String.format("%.2f", total) + " | Cajero: " + cajero + " | Fecha: " + fechaFormateada);
    }
}