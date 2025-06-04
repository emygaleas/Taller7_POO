package Empleado;

import Producto.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Empleado {
    public Administrador(String nombre, String id) {
        super(nombre, id, "Administrador");
    }

    public void agregarProducto(ArrayList<Producto> productos){
        Scanner sc=new Scanner(System.in);
        System.out.println("\n-----AGREGAR NUEVO PRODUCTO-----\n");
        System.out.print("Tipo de producto:\n1-Mochila\n2-Bolso\n3-MaletaViaje\n4-Lonchera\n");
        System.out.print("Opcion: ");
        int opcion=sc.nextInt();
        sc.nextLine();

        System.out.println("-----INGRESE LOS DATOS-----");
        System.out.println("Codigo: ");
        String codigo=sc.nextLine();

        System.out.println("Descripcion: ");
        String descripcion=sc.nextLine();

        System.out.print("Ubicación: ");
        String ubicacion = sc.nextLine();

        System.out.print("Stock: ");
        int stock = sc.nextInt();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();

        Producto nuevoProducto = null;
        switch (opcion){
            case 1 -> nuevoProducto = new Mochila(codigo,descripcion,ubicacion,stock,precio);
            case 2 -> nuevoProducto = new Bolso(codigo,descripcion,ubicacion,stock,precio);
            case 3 -> nuevoProducto = new MaletaViaje(codigo,descripcion,ubicacion,stock,precio);
            case 4 -> nuevoProducto = new Lonchera(codigo,descripcion,ubicacion,stock,precio);
            default -> System.out.println("El tipo de producto no es valido");
        }

        if (nuevoProducto!=null){
            productos.add(nuevoProducto);
            System.out.println("El producto se agrego de forma exitosa");
        }
    }
}