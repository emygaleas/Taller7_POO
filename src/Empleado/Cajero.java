package Empleado;

import Producto.Producto;
import Producto.Mochila;
import Producto.MaletaViaje;
import Venta.Venta;
import Main.SistemaMaletas; // Asegúrate de que esta importación sea correcta

public class Cajero extends Empleado {
    public Cajero(String nombre, String id) {
        super(nombre, id, "Cajero");
    }

    public double realizarVenta(Producto p, int cantidad) {
        double subtotal = p.getPrecio() * cantidad;
        if (p instanceof Mochila) subtotal *= 0.90;
        if (p instanceof MaletaViaje) subtotal *= 0.80;
        double total = subtotal * 1.15;
        System.out.println("Venta realizada. Total a pagar: $" + total);
        return total;
    }

    public void realizarVenta2(Producto p, int cantidad) {
        if (p.reducirStock(cantidad)) {
            double subtotal = p.getPrecio() * cantidad;
            if (p instanceof Mochila) subtotal *= 0.90;
            if (p instanceof MaletaViaje) subtotal *= 0.80;
            double total = subtotal * 1.15;
            System.out.println("Venta realizada. Total a pagar: $" + String.format("%.2f", total));
            SistemaMaletas.ventas.add(new Venta(p.getDescripcion(), cantidad, total, this.nombre));
        } else {
            System.out.println("Stock insuficiente. No se pudo realizar la venta.");
        }
    }

    public void consultarDetalle(Producto p) {
        p.mostrarDetalle();
    }
}