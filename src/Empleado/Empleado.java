package Empleado;

// SUPERCLASE: Empleado
public abstract class Empleado {
    protected String nombre;
    protected String id;
    protected String rol;

    public Empleado(String nombre, String id, String rol) {
        this.nombre = nombre;
        this.id = id;
        this.rol = rol;
    }

    public void mostrarInfo() {
        System.out.println("Empleado: " + nombre + " | Rol: " + rol);
    }

    public void mostrarInfo(String nivelDeDetalle) {
        if (nivelDeDetalle.equals("Perfil Completo")) {
            System.out.println("Empleado: " + nombre);
            System.out.println("ID: " + id);
            System.out.println("Rol: " + rol);
        }
    }

    public String getId() {
        return id;
    }
}