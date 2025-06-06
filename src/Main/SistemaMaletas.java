package Main;

import java.util.ArrayList;
import java.util.Scanner;

import Producto.*;
import Empleado.*;
import Venta.Venta;

// CLASE PRINCIPAL CON ARRAY Y MENU
public class SistemaMaletas {
    static ArrayList<Producto> productos = new ArrayList<>();
    static ArrayList<Empleado> empleados = new ArrayList<>();
    public static ArrayList<Venta> ventas = new ArrayList<>(); // Ahora public static para ser accesible desde Cajero
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarDatos();

        Cajero cajero1 = (Cajero) empleados.get(0);

        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Consultar detalle del producto (Cajero/Vendedor)");
            System.out.println("2. Consultar precio (Cliente)");
            System.out.println("3. Realizar venta (Cajero)");
            System.out.println("4. Ver todos los productos");
            System.out.println("5. Ver empleados registrados");
            System.out.println("6. Agregar productos");
            System.out.println("7. Ver historial de ventas");
            System.out.println("8. Mostrar productos con stock menor a 3 unidades");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch(opcion) {
                case 1 -> consultarDetalle();
                case 2 -> clienteConsultar();
                case 3 -> realizarVenta(cajero1);
                case 4 -> mostrarTodos();
                case 5 -> {
                    System.out.println("1. Mostrar información básica");
                    System.out.println("2. Mostrar información completa");
                    System.out.print("Opcion: ");
                    int opcionIn = sc.nextInt();
                    System.out.println();
                    switch (opcionIn) {
                        case 1 -> {
                            for (Empleado e : empleados) {
                                e.mostrarInfo();
                                System.out.println();
                            }
                        }
                        case 2 -> {
                            for (Empleado e : empleados) {
                                e.mostrarInfo("Perfil Completo");
                                System.out.println();
                            }
                        }
                        default -> System.out.println("Opción inválida");
                    }
                }
                case 6 -> {
                    System.out.print("\nIngrese su ID de empleado: ");
                    String idEmpleado = sc.next();
                    boolean AdministradorV = false;
                    Administrador admin = null;

                    for (Empleado e : empleados) {
                        if (e.getId().equals(idEmpleado) && e instanceof Administrador) {
                            AdministradorV = true;
                            admin = (Administrador) e;
                            break;
                        }
                    }

                    if (AdministradorV) {
                        admin.agregarProducto(productos);
                    } else {
                        System.out.println("No tiene permisos de administrador o ID de empleado incorrecto.");
                    }
                }
                case 7 -> mostrarHistorial();
                case 8 -> mostrarStock();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción inválida. Intente de nuevo.");
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
            System.out.print("Cantidad a comprar (máximo 5 productos): ");
            int cant = sc.nextInt();
            if (cant > 0 && cant <= 5){
                c.realizarVenta2(p, cant); // Llama al método correcto para registrar la venta
            } else {
                System.out.println("Cantidad máxima superada o inválida. Por favor, ingrese un número entre 1 y 5.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    static void mostrarStock() {
        System.out.println("\n--- Productos con stock menor o igual a 3 ---");
        boolean hayProductosBajoStock = false;
        for (Producto p : productos) {
            if (p.getStock() <= 3) {
                p.mostrarDetalle();
                hayProductosBajoStock = true;
            }
        }
        if (!hayProductosBajoStock) {
            System.out.println("No hay productos con stock menor o igual a 3 unidades.");
        }
    }

    static void mostrarTodos() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos registrados.");
        } else {
            System.out.println("\n--- Todos los productos ---");
            for (Producto p : productos) p.mostrarDetalle();
        }
    }

    static void mostrarHistorial() {
        System.out.println("\n--- Historial de Ventas ---");
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (Venta v : ventas) v.mostrar();
        }
    }
}