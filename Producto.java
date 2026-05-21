public class Producto {
    int id;
    String nombre;
    Producto izquierdo; // Puntero al hijo menor
    Producto derecho;   // Puntero al hijo mayor

    // Constructor
    public Producto(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.izquierdo = null; // Al nacer, no tiene hijos
        this.derecho = null;
    }
}