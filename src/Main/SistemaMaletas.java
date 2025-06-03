package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Producto.*;
import Empleado.*;

// CLASE PRINCIPAL CON ARRAY Y MENU
public class SistemaMaletas {
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Empleado> empleados = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();

        Cajero cajero1 = (Cajero) empleados.get(0);
        Cajero cajero2 = (Cajero) empleados.get(1);
        Vendedor vendedor1 = (Vendedor) empleados.get(2);

        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar detalle del producto (Cajero/Vendedor)");
            System.out.println("2. Consultar precio (Cliente)");
            System.out.println("3. Realizar venta (Cajero)");
            System.out.println("4. Ver todos los productos");
            System.out.println("5. Ver empleados registrados");
            System.out.println("7. Mostrar productos con stock menor a 3 unidades");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch(opcion) {
                case 1 -> consultarDetalle();
                case 2 -> clienteConsultar();
                case 3 -> realizarVenta(cajero1);
                case 4 -> mostrarTodos();
                case 5 -> mostrarEmpleados();
                case 7 -> mostrarStock();
            }
        } while(opcion != 0);
    }

    static void inicializarDatos() {
        // Productos
        productos.add(new Mochila("M01", "Mochila Escolar", "Estante A", 10, 20.5));
        productos.add(new Bolso("B01", "Bolso Mujer", "Estante B", 5, 35.0));
        productos.add(new MaletaViaje("MV01", "Maleta de Viaje", "Estante C", 3, 60.0));
        productos.add(new Lonchera("L01", "Lonchera Niños", "Estante D", 12, 15.0));

        // Empleados
        empleados.add(new Cajero("Carlos", "C01"));
        empleados.add(new Cajero("Laura", "C02"));
        empleados.add(new Vendedor("Luis", "V01"));
        empleados.add(new Vendedor("Ana", "V02"));
        empleados.add(new Vendedor("Mario", "V03"));
        empleados.add(new Administrador("Lucia", "A01"));
        empleados.add(new Gerente("Raul", "G01"));
        empleados.add(new PersonalLimpieza("Pablo", "L01"));
        empleados.add(new PersonalLimpieza("Sofia", "L02"));
    }

    static Producto buscarProducto(String codigo) {
        for (Producto p : productos)
            if (p.getCodigo().equalsIgnoreCase(codigo))
                return p;
        return null;
    }

    static void consultarDetalle() {
        System.out.print("Ingrese el código del producto: ");
        String cod = sc.next();
        Producto p = buscarProducto(cod);
        if (p != null) p.mostrarDetalle();
        else System.out.println("Producto no encontrado.");
    }

    static void clienteConsultar() {
        System.out.print("Ingrese el código del producto: ");
        String cod = sc.next();
        Producto p = buscarProducto(cod);
        if (p != null) p.mostrarPrecio();
        else System.out.println("Producto no encontrado.");
    }

    static void realizarVenta(Cajero c) {
        System.out.print("Ingrese el código del producto: ");
        String cod = sc.next();
        Producto p = buscarProducto(cod);
        if (p != null) {
            System.out.print("Cantidad a comprar: ");
            int cant = sc.nextInt();
            c.realizarVenta(p, cant);
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    static void mostrarStock() {
        System.out.println("\n--- Productos con stock menor a 3 ---");
        for (Producto p : productos)
            if (p.getStock() <= 3)
                p.mostrarDetalle();
    }


    static void mostrarTodos() {
        for (Producto p : productos) p.mostrarDetalle();
    }

    static void mostrarEmpleados() {
        for (Empleado e : empleados) e.mostrarInfo();
    }
}
