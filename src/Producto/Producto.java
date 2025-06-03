package Producto;

// SUPERCLASE PRODUCTO
public class Producto {
    protected String codigo;
    protected String descripcion;
    protected String ubicacion;
    protected int stock;
    protected double precio;

    public Producto(String codigo, String descripcion, String ubicacion, int stock, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.stock = stock;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void mostrarDetalle() {
        System.out.println("\nCódigo: " + codigo);
        System.out.println("Descripción: " + descripcion);
        System.out.println("Ubicación: " + ubicacion);
        System.out.println("Stock: " + stock);
        System.out.println("Precio: $" + precio);
    }

    public void mostrarPrecio() {
        System.out.println("\nPrecio del producto: $" + precio);
    }
}
